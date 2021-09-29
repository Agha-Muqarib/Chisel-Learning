// package Lab08

// import chisel3._
// import org.scalatest._
// import chiseltest._
// import Generate_ProcessorTile._

// class Example03Test extends FreeSpec with ChiselScalatestTester {
    
//     "Example 03 Test" in {
        
//         test(new InstMem(initFile) {c =>
        
//         c.io.addr.poke(3.U)

//         c.clock.step(5)

//         c.io.inst.expect(4.U)

//     }
//   }
// }