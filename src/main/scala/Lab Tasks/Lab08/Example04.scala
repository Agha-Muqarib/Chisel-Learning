package Lab08

// Memory forwarding example

import chisel3._
import chisel3.util._

class Forwarding extends Module {

    val io = IO ( new Bundle {

        val out = Output(UInt(32.W))
        val readAddress = Input(UInt(10.W))
        val writeAddress = Input(UInt(10.W))
        val wrData = Input(UInt(32.W))
        val wr_en = Input(Bool())

    })

val memory = SyncReadMem(1024, UInt(32.W))
val wrDataReg = RegNext(io.wrData)
val goForward = RegNext(io.writeAddress === io.readAddress && io.wr_en)
val memData = memory.read(io.readAddress)

when (io.wr_en) {
    memory . write ( io . writeAddress , io . wrData )
}

    io.out := Mux(goForward, wrDataReg, memData)

}
