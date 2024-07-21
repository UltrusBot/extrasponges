package me.ultrusmods.extrasponges;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {

	public static final String MOD_ID = "extrasponges";
	public static final String MOD_NAME = "ExtraSponges";
	public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
	public static ResourceLocation id(String id) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, id);
	}
}