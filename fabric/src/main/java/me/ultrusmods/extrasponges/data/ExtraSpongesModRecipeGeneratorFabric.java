package me.ultrusmods.extrasponges.data;

import me.ultrusmods.extrasponges.register.ItemRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.impl.resource.conditions.conditions.TagsPopulatedResourceCondition;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.data.recipes.RecipeBuilder.getDefaultRecipeId;

public class ExtraSpongesModRecipeGeneratorFabric extends FabricRecipeProvider {
    public ExtraSpongesModRecipeGeneratorFabric(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {

        var tinIngotTag = create("ingots/tin");

        createSpongeRecipe(Items.SPONGE, tinIngotTag, ItemRegistry.TIN_SPONGE, ItemRegistry.WET_TIN_SPONGE, exporter);


        var steelIngotTag = create("ingots/steel");
        createSpongeRecipe(ItemRegistry.IRON_SPONGE, steelIngotTag, ItemRegistry.STEEL_SPONGE, ItemRegistry.WET_STEEL_SPONGE, exporter);

        var leadIngotTag = create("ingots/lead");
        createSpongeRecipe(Items.SPONGE, leadIngotTag, ItemRegistry.LEAD_SPONGE, ItemRegistry.WET_LEAD_SPONGE, exporter);

    }

    public void createSpongeRecipe(Item spongeBase, TagKey<Item> requirement, Item resultItem, Item wetForm, RecipeOutput exporter) {
        var condition = new TagsPopulatedResourceCondition(requirement);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultItem, 8)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', spongeBase)
                .define('U', requirement)
                .unlockedBy("has_upgrade", has(requirement))
                .save(withConditions(exporter, condition));



        SimpleCookingRecipeBuilder.smelting(Ingredient.of(wetForm),
                        RecipeCategory.BUILDING_BLOCKS,
                        resultItem, 0.15F, 200)
                .unlockedBy("has_wet_sponge", has(wetForm)).save(exporter, getDefaultRecipeId(resultItem).withSuffix("_smelted"));

    }


    private static TagKey<Item> create(String string) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", string));
    }
}
