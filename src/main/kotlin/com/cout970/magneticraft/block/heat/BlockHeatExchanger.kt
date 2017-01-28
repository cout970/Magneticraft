package com.cout970.magneticraft.block.heat

import com.cout970.magneticraft.tileentity.heat.TileHeatExchanger
import net.minecraft.block.ITileEntityProvider
import net.minecraft.block.material.Material
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World

/**
 * Created by cout970 on 04/07/2016.
 */
object BlockHeatExchanger : BlockHeatBase(Material.ROCK, "heat_exchanger"), ITileEntityProvider {

    override fun createNewTileEntity(worldIn: World?, meta: Int): TileEntity = TileHeatExchanger()

}