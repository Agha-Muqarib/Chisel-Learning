package Lab07

import chisel3._
import chisel3.util._
import chisel3.experimental.ChiselEnum

class My_Queue extends Bundle {

    val f1 = Input(Bool())
    val f2 = Input(Bool())
    val r1 = Input(Bool())
    val r2 = Input(Bool())
    val out = Output(UInt(4.W))
    
}

class Task01 extends Module {

    val io = IO (new My_Queue)
    val s0 :: s1 :: s2 :: s3 :: Nil = Enum(4)
    val s4 = 4.U
    val s5 = 5.U
    val state = RegInit(s0)
    io.out := 0.U
    
    when ((state === s2 && (io.f1 === false.B && io.r1 === false.B)) ||
          (state === s2 && (io.f1 === true.B)) || (state === s2 && (io.f1 === false.B) && 
          (io.r1 === true.B))){
        
                io.out:=3.U
    }
    
    .elsewhen((state === s4 && (io.f2 === true.B)) || (state === s4 && 
              (io.f2 === false.B && io.r2 === false.B)) || (state === s4 && 
              (io.f2 === false.B ) && (io.r2 === true.B))) {
       
            io.out := 7.U
    }
    
    .otherwise{

        io.out := 0.U

    }

    switch (state) {

        is (s0) {

            when (io.f1 === false.B && io.f2 === false.B) {
                state := s0
            }
            
            .elsewhen ((io.f1 === true.B) && (io.f2 === false.B)) {
                state := s1
            }
            
            .elsewhen ((io.f1 === false.B) && (io.f2 === true.B)) {
                state := s5
            }
            
            .elsewhen ((io.f1 === true.B) && (io.f2 === true.B)) {
                state := s1
            }
        } 
        
        is (s1) {

            when (io.f1 === false.B && io.r1 === false.B) { 
                state := s1
            }
            
            .elsewhen (io.f1 === true.B) {
                state := s2
            }
            
            .elsewhen ((io.f1 === false.B) && (io.r1 === true.B)) {
                state := s0
            }
        } 
        
        is (s2) {
            
            when (io.f1 === false.B && io.r1 === false.B) {
                state := s2
            }
            
            .elsewhen (io.f1 === true.B){
                state := s3
            }
            
            .elsewhen (io.f1 === false.B && io.r1 === true.B) {
                state := s1
            }
        } 
        
        is (s3) {
            state := s0
        } 
        
        is (s4) {

            when (io.f2 === true.B) {
                state := s3
            }
            
            .elsewhen (io.f2 === false.B && io.r2 === false.B) {
                state := s4
            }
            
            .elsewhen (io.f2 ===  false.B && io.r2 === true.B) {
                state := s5
            }
        } 
        
        is (s5) {
            
            when (io.f2 === true.B) {
                state := s4
            }
            
            .elsewhen (io.f2 === false.B && io.r2 === false.B) {
                state := s5
            }
            
            .elsewhen(io.f2 === false.B && io.r2 === true.B) {
                state := s0
            }
        }
    }
}