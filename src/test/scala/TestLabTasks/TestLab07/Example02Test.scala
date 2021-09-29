package Lab07

import chisel3._
import org.scalatest._
import chiseltest._

class Example02Test extends FreeSpec with ChiselScalatestTester {
    
    "Example 02" in {
        
        test(new CounterUpDown(3)) {c =>
        
        c.io.data_in.poke(3.U)
        c.clock.step(20)
        // c.io.out.expect(true.B)

    }
  }
}

// import chisel3.iotesters.{Driver, PeekPokeTester}

// class Example02Test(c: CounterUpDown) extends PeekPokeTester(c) {
//     var data_in = 6
//     poke(c.io.data_in, data_in.U)
//     step(40)

//     object CounterUpDown_Main extends App {
//       iotesters.Driver.execute(Array( " --is - verbose " , 
//           "-- generate - vcd - output", "on", "-- backend - name", "firrtl" ), () = > new CounterUpDown(8))
//           { c = > new TestCounterUpDown(c)}

// }
//     // data_in = 10
//     // poke(c.io.data_in, data_in.U)
//     // step (50)
// }

