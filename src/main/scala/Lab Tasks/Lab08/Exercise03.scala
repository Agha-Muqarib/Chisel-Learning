package Lab08

import chisel3._
import chisel3.util._
import chisel3.experimental.ChiselEnum
import chisel3.util.experimental.loadMemoryFromFile

class InstIO extends Bundle {

    val input = Input(UInt(32.W))
    val out = Output(UInt(32.W))

}

class InsMem extends Module {

    val io = IO(new InstIO)
    val instrMem = Mem(32, UInt(32.W))

    loadMemoryFromFile(instrMem, "src/main/scala/LabTasks/Lab08/instrFile.txt")
    
    io.out := instrMem(io.input)

}