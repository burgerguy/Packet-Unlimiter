package com.github.burgerguy.packetunlimiter.mixin;

import org.spongepowered.asm.mixin.injection.ModifyArg;

import net.minecraft.nbt.PositionTracker;
import net.minecraft.network.PacketByteBuf;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PacketByteBuf.class)
public class PacketByteBufMixin {
	
	@ModifyArg(method = "readCompoundTag()Lnet/minecraft/nbt/CompoundTag;",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/network/PacketByteBuf;method_30616(Lnet/minecraft/nbt/PositionTracker;)Lnet/minecraft/nbt/CompoundTag;"))
	private PositionTracker increaseLimit(PositionTracker in) {
		return PositionTracker.DEFAULT;
	}
}
