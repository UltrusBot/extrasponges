package me.ultrusmods.extrasponges.data;

import me.ultrusmods.extrasponges.register.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.NotCondition;
import net.neoforged.neoforge.common.conditions.TagEmptyCondition;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.data.recipes.RecipeBuilder.getDefaultRecipeId;

public class ExtraSpongesModRecipeGeneratorNeoForge extends RecipeProvider {
    public ExtraSpongesModRecipeGeneratorNeoForge(PackOutput p_248933_, CompletableFuture<HolderLookup.Provider> p_323846_) {
        super(p_248933_, p_323846_);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        var tinIngotTag = create("ingots/tin");

        createSpongeRecipe(Items.SPONGE, tinIngotTag, ItemRegistry.TIN_SPONGE, ItemRegistry.WET_TIN_SPONGE, recipeOutput);

        var steelIngotTag = create("ingots/steel");
        createSpongeRecipe(ItemRegistry.IRON_SPONGE, steelIngotTag, ItemRegistry.STEEL_SPONGE, ItemRegistry.WET_STEEL_SPONGE, recipeOutput);


        var leadIngotTag = create("ingots/lead");
        createSpongeRecipe(Items.SPONGE, leadIngotTag, ItemRegistry.LEAD_SPONGE, ItemRegistry.WET_LEAD_SPONGE, recipeOutput);
    }

    public void createSpongeRecipe(Item spongeBase, TagKey<Item> requirement, Item resultItem, Item wetForm, RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultItem, 8)
                .pattern("SSS")
                .pattern("SUS")
                .pattern("SSS")
                .define('S', spongeBase)
                .define('U', requirement)
                .unlockedBy("has_upgrade", has(requirement))
                .save(exporter.withConditions(new NotCondition(new TagEmptyCondition(requirement))));



        SimpleCookingRecipeBuilder.smelting(Ingredient.of(wetForm),
                        RecipeCategory.BUILDING_BLOCKS,
                        resultItem, 0.15F, 200)
                .unlockedBy("has_wet_sponge", has(wetForm)).save(exporter, getDefaultRecipeId(resultItem).withSuffix("_smelted"));

    }


    private static TagKey<Item> create(String string) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", string));
    }
}
