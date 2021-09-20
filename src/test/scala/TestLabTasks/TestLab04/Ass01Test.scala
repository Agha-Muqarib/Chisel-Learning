package Lab04

import chisel3._
import chisel3.util
import org.scalatest._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation
import scala.util.Random


class Ass01Test extends FreeSpec with ChiselScalatestTester {
    
    "Ass 01 Test" in {
        
        test(new BranchControl) { c =>
        
        val funct3Array = Array(0,1,2,3,4,5,6,7)

        for ( i <- 0 until 100) {

            val input_a = Random.nextLong() & 0xFFFFFFFFL
            val input_b = Random.nextLong() & 0xFFFFFFFFL
            val index = Random.nextInt(7)
            val funct_3 = funct3Array(index)
            val result = funct_3 match {

                case 0 => if (input_a > input_b) 1 else 0
                case 1 => if (input_a === input_b) 1 else 0
                case 2 => if (input_a < input_b) 1 else 0
                case 3 => if (input_a != input_b) 1 else 0
                case 4 => if (input_a > input_b) 1 else 0
                case 5 => if (input_a === input_b) 1 else 0
                case 6 => if (input_a < input_b) 1 else 0
                case 7 => if (input_a != input_b) 1 else 0
                case _ => 0
            }

            c.io.inputA.poke(input_a.S)
            c.io.inputB.poke(input_b.S)
            c.io.funct3.poke(funct_3.U)
            c.clock.step(1)
            c.io.branchTaken.expect(result.B)
            
            }
        }   
    }
}