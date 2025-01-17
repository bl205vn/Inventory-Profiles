/*
 * Inventory Profiles Next
 *
 *   Copyright (c) 2019-2020 jsnimda <7615255+jsnimda@users.noreply.github.com>
 *   Copyright (c) 2021-2022 Plamen K. Kosseff <p.kosseff@gmail.com>
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

package org.anti_ad.mc.ipnext.specific.event

import org.anti_ad.mc.common.gui.NativeContext
import org.anti_ad.mc.common.vanilla.Vanilla
import org.anti_ad.mc.common.vanilla.alias.ContainerScreen
import org.anti_ad.mc.common.vanilla.render.gPopMatrix
import org.anti_ad.mc.common.vanilla.render.gPushMatrix
import org.anti_ad.mc.common.vanilla.render.gTranslatef
import org.anti_ad.mc.ipnext.ingame.`(containerBounds)`

interface PLockSlotHandler {

    val enabled: Boolean

    fun onForegroundRender(context: NativeContext) {
        if (!enabled) return
        val screen = Vanilla.screen() as? ContainerScreen<*> ?: return
        gPushMatrix() // see HandledScreen.render() line 98: RenderSystem.translatef()
        val topLeft = screen.`(containerBounds)`.topLeft
        gTranslatef(-topLeft.x.toFloat(),
                    -topLeft.y.toFloat(),
                    0f)

        //gTranslatef(-topLeft.x.toFloat(), -topLeft.y.toFloat(), 0f)
        drawForeground(context)
        drawConfig(context)
        gPopMatrix()
    }

    fun drawForeground(context: NativeContext)
    fun drawConfig(context: NativeContext)
}
