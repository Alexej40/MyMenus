package com.example.mymenus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import com.example.mymenus.databinding.ActivityMultiBinding
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.Toast

class MultiActivity : AppCompatActivity() {
    lateinit var binding: ActivityMultiBinding
    lateinit var radioGroup: RadioGroup
    lateinit var radioGroup1: RadioGroup
    lateinit var seekBarR: SeekBar
    lateinit var seekBarG: SeekBar
    lateinit var seekBarB: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        radioGroup = binding.multiRG1
        radioGroup.clearCheck()

        // СЛУШАТЕЛЬ НАЖАТИЙ первой группы RadioButtons
        radioGroup.setOnCheckedChangeListener {_, checkedId ->
            //val checkedRadioButtonId = radioGroup.checkedRadioButtonId
            when (checkedId){
                -1 -> {
                }
                binding.multiRBAnim1.id -> {
                    Toast.makeText(this, "выбрана первая анимация", Toast.LENGTH_SHORT).show()
                    binding.multiTView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_rotate))
                }
                binding.multiRBAnim2.id -> {
                    Toast.makeText(this, "выбрана вторая анимация", Toast.LENGTH_SHORT).show()
                    binding.multiTView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_combo))

                }
            }
        }
        // СЛУШАТЕЛЬ НАЖАТИЙ второй группы RadioButtons
        radioGroup1 = binding.multiRG2
        radioGroup1.setOnCheckedChangeListener {_, checkedId ->
            //val checkedRadioButtonId = radioGroup.checkedRadioButtonId
            when (checkedId){
                -1 -> {
                    Toast.makeText(this, "Ничего не выбрано", Toast.LENGTH_SHORT).show()
                }
                binding.multiRBStart.id -> {
                    Toast.makeText(this, "Анимация стартует", Toast.LENGTH_SHORT).show()

                }
                binding.multiRBStop.id -> {
                    Toast.makeText(this, "Анимация остановлена", Toast.LENGTH_SHORT).show()
                    // снимаем выделения со всех элементов РадиоГруппы 1
                    radioGroup.clearCheck()
                    // отменяем все активности и анимацию для элемента TextView
                    binding.multiTView.x = 300.toFloat()
                    binding.multiTView.y = 1600.toFloat()

                }
            }
        }
        // обрабатываем реакцию на изменение ползунков
        // Красный ползунок
        seekBarR = binding.multiSBRed
        seekBarR.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Ваш код
                colorChange()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {    }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(this@MultiActivity, "seekBarR - Red = ${seekBarR.getProgress().toString()}", Toast.LENGTH_SHORT).show()
            }
        })
        // Синий ползунок
        seekBarB = binding.multiSBBlue
        seekBarB.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Ваш код
                colorChange()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {    }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(this@MultiActivity, "seekBarB - Red = ${seekBarB.getProgress().toString()}", Toast.LENGTH_SHORT).show()
            }
        })
        // Зеленый ползунок
        seekBarG = binding.multiSBGreen
        seekBarG.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Ваш код
                colorChange()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {    }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(this@MultiActivity, "seekBarG - Red = ${seekBarG.getProgress().toString()}", Toast.LENGTH_SHORT).show()
            }
        })



    }

    // реакция на изменение ползунка - сдвиг цвета
    fun colorChange() {
        binding.multiTView.setBackgroundColor(0xff000000.toInt() +
                binding.multiSBRed.getProgress().toInt() * 0x10000 +
                binding.multiSBGreen.getProgress().toInt() * 0x100 +
                binding.multiSBBlue.getProgress().toInt())



    }


    // Обработчик нажатий для кнопки
    fun multiIButtonOnClick(view: View){
        val myDialogColor = MultiColorActivity()
        val manager = supportFragmentManager
        myDialogColor.show(manager, "text")

        Toast.makeText(this, "Кнопка нажата", Toast.LENGTH_SHORT).show()
    }





}