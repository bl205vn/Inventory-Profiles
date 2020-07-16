package io.github.jsnimda.common.vanilla.alias

import com.mojang.blaze3d.platform.GlStateManager
import net.minecraft.client.font.TextRenderer
import net.minecraft.client.gui.DrawableHelper
import net.minecraft.client.render.DiffuseLighting
import net.minecraft.text.LiteralText
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText

typealias Text = Text
typealias LiteralText = LiteralText
typealias TranslatableText = TranslatableText

typealias TextRenderer = TextRenderer

typealias DrawableHelper = DrawableHelper

//typealias RenderSystem = RenderSystem
//typealias MatrixStack = MatrixStack
typealias DiffuseLighting = DiffuseLighting
typealias GlStateManager = GlStateManager
typealias RenderSystem = GlStateManager
typealias SrcFactor = GlStateManager.SourceFactor
typealias DstFactor = GlStateManager.DestFactor

