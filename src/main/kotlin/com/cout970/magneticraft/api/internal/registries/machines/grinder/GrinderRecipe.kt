package com.cout970.magneticraft.api.internal.registries.machines.grinder

import com.cout970.magneticraft.api.internal.ApiUtils
import com.cout970.magneticraft.api.registries.machines.grinder.IGrinderRecipe
import net.minecraft.item.ItemStack
import net.minecraftforge.oredict.OreDictionary

/**
 * Created by cout970 on 22/08/2016.
 */
data class GrinderRecipe(
        private val input: ItemStack,
        private val output: ItemStack,
        private val ticks: Float,
        private val oreDict: Boolean
) : IGrinderRecipe {

    override fun getInput(): ItemStack = input.copy()

    override fun getOutput(): ItemStack = output.copy()

    override fun getDuration(): Float = ticks

    override fun matches(input: ItemStack?): Boolean {
        if (ApiUtils.equalsIgnoreSize(input, this.input)) return true
        if (oreDict) {
            val ids = OreDictionary.getOreIDs(this.input)
            return OreDictionary.getOreIDs(input).any { it in ids }
        }
        return false
    }
}