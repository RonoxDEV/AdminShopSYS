/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.adm.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.adm.AdmMod;

public class AdmModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, AdmMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> DONE = REGISTRY.register("done", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("adm", "done")));
}