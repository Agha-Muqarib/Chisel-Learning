package Lab02

import chisel3._ 
import chisel3.util._ 


class Task02 extends Module {
    
    val io = IO ( new Bundle {

        val in0 = Input(Bool())
        val in1 = Input(Bool())
        val in2 = Input(Bool())
        val in3 = Input(Bool())
        val in4 = Input(Bool())
        val in5 = Input(Bool())
        val in6 = Input(Bool())
        val in7 = Input(Bool())
        val sel = Input(UInt(3.W))
        val out = Output(Bool())

    })

    val firstMuxLookup = MuxLookup(io.sel(1), false.B, Array(
        
        (0.U) -> MuxLookup(io.sel(0),false.B, Array(

            (0.U) -> io.in0,
            (1.U) -> io.in1

        )),
        
        (1.U) -> MuxLookup(io.sel(0), false.B, Array(

            (0.U) -> io.in2,
            (1.U) -> io.in3

        ))
    ))

    val secondMuxLookup = MuxLookup(io.sel(1), false.B, Array(
        
        (0.U) -> MuxLookup(io.sel(0), false.B, Array(
            
            (0.U) -> io.in4,
            (1.U) -> io.in5

        )),

        (1.U) -> MuxLookup(io.sel(0), false.B, Array(
            (0.U) -> io.in6,
            (1.U) -> io.in7
        ))
    ))

    io.out := MuxLookup(io.sel(2), false.B, Array(

        (0.U) -> firstMuxLookup,
        (1.U) -> secondMuxLookup

    ))


}