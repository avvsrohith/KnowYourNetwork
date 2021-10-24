package com.example.knowyournetwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.knowyournetwork.databinding.ActivityFormulaeBinding
import java.lang.Math.pow
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.sqrt

class Formulae : AppCompatActivity() {
    private lateinit var binding: ActivityFormulaeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFormulaeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.analyseBtn.setOnClickListener(){
            val R = binding.REt.text.toString().toDouble()
            val L=binding.LEt.text.toString().toDouble()
            val C=binding.CEt.text.toString().toDouble()

            val o1=roundOffDecimal(res_freq(L,C))
            val o2=roundOffDecimal(hpfq_1(R,L,C))
            val o3=roundOffDecimal(hpfq_2(R,L,C))
            val o4=roundOffDecimal(Bandwidth(R,L))
            val o5=roundOffDecimal(qual_fac(R,L,C))

            binding.resfreqTv.text="Resonant Frequency =$o1 hz"
            binding.halfpowTv.text="Half power frequencies are : $o2 hz,$o3 hz"
            binding.bandwidTv.text="BandWidth = $o4 hz"
            binding.qualfacTv.text="Quality Factor = $o5"
        }

    }

    fun to_hz(a:Double)=(a/(2*Math.PI))

    fun res_freq(L:Double,C:Double)=to_hz(1/ sqrt(L*C))

    fun Bandwidth(R:Double,L:Double)=to_hz(R/L)

    fun qual_fac(R:Double,L:Double,C:Double)=((pow((L/C),0.5))/R)

    fun hpfq_1(R:Double,L:Double,C:Double) : Double{
        val b=Bandwidth(R,L)
        return to_hz((-b/2)+pow((pow((b/2), 2.0)+pow(res_freq(L,C), 2.0)),0.5))
    }

    fun hpfq_2(R:Double,L:Double,C:Double) : Double{
        val b=Bandwidth(R,L)
        return to_hz((+b/2)+pow((pow((b/2), 2.0)+pow(res_freq(L,C), 2.0)),0.5))
    }

    fun roundOffDecimal(number: Double): Double? {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        return df.format(number).toDouble()
    }
}