// package Lab05

// import org.scalatest._
// import chiseltest._
// import chisel3._

// class Example08Test extends FreeSpec with ChiselScalatestTester {
    
//     "Example 08 Test" in {
    
//         test(new ALU(4, UInt(32.W))(_ & _)) { c =>

//         c.io.dw.poke(2.U)
//         c.io.fn.poke(4.U)
//         c.io.in2.poke(3.U)
//         c.io.in1.poke(5.U)

//         c.clock.step(10)

//         c.io.out.expect(0.U)
//         c.io.adder_out.expect(0.U)
//         c.io.cmp_out.expect(0.U)


//          val dw = Bits(INPUT, SZ_DW)
//         val fn = Bits(INPUT, SZ_ALU_FN)
//         val in2 = UInt(INPUT, xLen) // xLen is an implicit parameter
//         val in1 = UInt(INPUT, xLen)
//         val out = UInt(OUTPUT, xLen)
//         val adder_out = UInt(OUTPUT, xLen) 
//         val cmp_out = Bool(OUTPUT)
   
//         }
//     }
// }