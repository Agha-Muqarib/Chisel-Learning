// package Lab03

// import org.scalatest._
// import chiseltest._
// import chisel3._

// class Example05Test extends FreeSpec with ChiselScalatestTester {
    
//     "Example 05 Test" in {
        
//         test(new Valid_Interf) { c =>

//         c.io.in.poke(1.U)
    
//         c.clock.step(1)
    
//         c.io.out.expect(2.U)
//         c.io.data_bits.expect(1.U)

   
//         }
//     }
// }