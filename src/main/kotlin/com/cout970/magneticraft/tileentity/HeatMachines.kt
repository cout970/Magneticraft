package com.cout970.magneticraft.tileentity

import com.cout970.magneticraft.misc.block.getOrientation
import com.cout970.magneticraft.misc.fluid.Tank
import com.cout970.magneticraft.misc.tileentity.RegisterTileEntity
import com.cout970.magneticraft.tileentity.core.TileBase
import com.cout970.magneticraft.tileentity.modules.ModuleCombustionChamber
import com.cout970.magneticraft.tileentity.modules.ModuleFluidHandler
import com.cout970.magneticraft.tileentity.modules.ModuleInventory
import com.cout970.magneticraft.tileentity.modules.ModuleSteamBoiler
import net.minecraft.util.EnumFacing
import net.minecraft.util.ITickable

/**
 * Created by cout970 on 2017/08/10.
 */

@RegisterTileEntity("combustion_chamber")
class TileCombustionChamber : TileBase(), ITickable {

    val facing: EnumFacing get() = getBlockState().getOrientation()
    val invModule = ModuleInventory(1)
    val combustionChamberModule = ModuleCombustionChamber(invModule)

    init {
        initModules(invModule, combustionChamberModule)
    }

    override fun update() {
        super.update()
    }
}

@RegisterTileEntity("steam_boiler")
class TileSteamBoiler : TileBase(), ITickable {
    val waterTank = Tank(
            capacity = 1000,
            allowInput = true,
            allowOutput = false
    )
    val steamTank = Tank(
            capacity = 16000,
            allowInput = false,
            allowOutput = true
    )

    val fluidModule = ModuleFluidHandler(waterTank, steamTank)
    val boilerModule = ModuleSteamBoiler(waterTank, steamTank)

    init {
        initModules(fluidModule, boilerModule)
    }

    override fun update() {
        super.update()
    }
}