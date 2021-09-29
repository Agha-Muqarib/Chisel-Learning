package Lab08

import chisel3._

class BankedMemory extends Module {

    val width : Int = 8

    val io = IO (new Bundle{
    val enable = Input(Bool())
    val write = Input(Bool()) 
    val writeAddress = Input(UInt(10.W)) 
    val readAddress = Input(UInt(10.W)) 
    val mask = Input(Vec(4, Bool())) 
    val dataIn = Input(Vec(4, UInt(width.W)))  
    val dataOut = Output(Vec(4, UInt( width.W)))  
    
    })

val memory = SyncReadMem(1024,Vec(4,UInt(width.W)))

val wrData = RegNext(io.dataIn)
val goForward = RegNext(io.writeAddress === io.readAddress && io.write)

when(io.write){

    memory.write(io.writeAddress,io.dataIn, io.mask)

}

val rdMem = memory.read(io.readAddress, io.enable)

io.dataOut := Mux(goForward, wrData, rdMem)
io.dataOut := rdMem

}