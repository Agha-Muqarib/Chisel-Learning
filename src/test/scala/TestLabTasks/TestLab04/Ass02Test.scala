// package Lab04

// import org.scalatest._
// import chiseltest._
// import chisel3._
// import scala.util._

// class Ass02Test extends FreeSpec with ChiselScalatestTester {

//     "Ass 02 Test" in {
          
//           test(new Ass02) { c =>
//           val instructionArray = Array("h0000fa37") //, "h00300693", "h0000c637", "h0000f7b7")
          
//           for (i <- 0 until 100){
            
//               val instructions = instructionArray(Random.nextInt(1))
//               val result = instructions match {
 
//                   case ("h0000fa37") => 61440
//                   // case ("h0000f7b7") => 15
//                   // case ("h00300693") => 3
//                   // case ("h0000c637") => 12
//           }

//         c.io.instr.poke(instructions.U)
//         c.io.pc.poke(4.U)
//         c.io.immSel.expect(result.U)

//       }
//     }
//   }
// }