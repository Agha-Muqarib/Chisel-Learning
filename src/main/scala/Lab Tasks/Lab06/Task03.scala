package Lab06

import chisel3._
import chisel3.util._

// shift_reg_with_parallel_load

class Task03(len: Int) extends Module {

    val io = IO (new Bundle{
        
        val load_in = Vec(len, Input(UInt(len.W)))
        val load = Input(Bool())
        val out = Vec(len, Output(UInt(len.W)))

    })

    val state = RegInit(0.U(len.W))
    val loadReg = RegInit(0.U(len.W))

    io.out(0) := 0.U

    when (io.load === 0.U) {
        
        loadReg := loadReg + 1.U
        state := io.load_in(loadReg)

        io.out(0) := state(0)

    }
}