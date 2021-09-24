package Lab05

import chisel3._

// class definition with function as parameter

class Exercise03[T <: Data](n: Int, generic : T) (op: (T, T) => T) extends Module {
    
    require ( n > 0) // " reduce only works on non - empty Vecs "

    val io = IO(new Bundle {
        
        val in = Input(Vec(n, generic))
        val out = Output(Vec(n, generic))

})

    io.out(0) := io.in.reduce(op)
    io.out(1) := io.in.reduce(op)
    io.out(2) := io.in.reduce(op)
    io.out(3) := io.in.reduce(op)

}

// // Implement addition operation

// object UserOperator1 extends App {

//     println((new chisel3.stage.ChiselStage).emitVerilog(new Operator(2, UInt(16.W))(_ + _)))

// }

// // Implement AND operation

// object UserOperator2 extends App {
    
//     println((new chisel3.stage.ChiselStage).emitVerilog(new Operator(3, UInt(8.W))( _ & _ )))

// }