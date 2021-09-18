// package Lab03

// import chisel3._
// import chisel3.util._
// // import chisel3.iotesters._


// // data bits without valid signal

// class DataWithoutValid extends Bundle{

//     val data_bits = Output(UInt(8.W))

// }

// class Valid_Interf extends Module {
    
//     val io = IO(new Bundle {
        
//         val in = Flipped(Valid(UInt(8.W))) // valid = Input ,  
//         val out = Valid(new DataWithoutVali)) // valid = Output ,
// })

//     io.out := RegNext(io.in)

// }



