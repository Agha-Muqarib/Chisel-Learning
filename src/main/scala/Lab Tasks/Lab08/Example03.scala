// package Lab08

// import chisel3._
// import chisel3.util._
// import chisel3.util.experimental.loadMemoryFromFile
// import scala.io.Source


// trait Config {

//     val WLEN = 32
//     val INST_MEM_LEN = 32
// }

// object Generate_ProcessorTile extends App {

//     var initFile = "src/main/scala/LabTasks/Lab08/main.txt"
//     // var file = new ProcessorTile(initFile)

// }

// class InstMemIO extends Bundle with Config {

//     val addr = Input(UInt(WLEN.W))
//     val inst = Output(UInt(WLEN.W))

// }

// class InstMem (initFile: String) extends Module with Config {

//     val io = IO(new InstMemIO)
    
//     // INST_MEM_LEN in Bytes or INST_MEM_LEN / 4 in words
    
//     val imem = Mem(INST_MEM_LEN, UInt(WLEN.W))
//     loadMemoryFromFile(imem, initFile)
//     io.inst := imem(io.addr / 4.U)

// }

