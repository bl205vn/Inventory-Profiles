/*
 * Inventory Profiles Next
 *
 *   Copyright (c) 2023 Plamen K. Kosseff <p.kosseff@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.anti_ad.mc.ipnext.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import org.anti_ad.mc.ipnext.event.villagers.VillagerTradeManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerInteractEntityC2SPacket.class)
public class MixinPlayerInteractEntityC2SPacket {

    @Inject(method = "Lnet/minecraft/network/packet/c2s/play/PlayerInteractEntityC2SPacket;<init>(Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Hand;Lnet/minecraft/util/math/Vec3d;Z)V",
            at = @At("TAIL"))
    private void interactAt(Entity entity, Hand hand, Vec3d hitPos, boolean playerSneaking, CallbackInfo ci) {
        if (entity instanceof MerchantEntity) {
            VillagerTradeManager.INSTANCE.setCurrentVillager((MerchantEntity) entity);
        }
    }
}
