package imt.respect.bluetoothswitch

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Switch
import imt.respect.bluetoothswitch.databinding.ActivityMainBinding
/*
class MainActivity : AppCompatActivity() {
    private lateinit var switcher:Switch
    private var REQUEST_CODE_ENABLE_BT:Int = 1
    private lateinit var bAdapter:BluetoothAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bAdapter = BluetoothAdapter.getDefaultAdapter()

        binding.switcher.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
            @SuppressLint("MissingPermission")
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                if (isChecked){
                    bAdapter.enable()
                }else{
                    bAdapter.disable()
                }
            }
        })


    }
}

 */

class MainActivity : AppCompatActivity(){
    lateinit var bluetoothReceiver: BluetoothReceiver
    lateinit var binding: ActivityMainBinding
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bluetoothReceiver = BluetoothReceiver()
        val intentFilter = IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED)
        registerReceiver(bluetoothReceiver, intentFilter)

        val bAdapter=BluetoothAdapter.getDefaultAdapter()

        binding.switcher.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
            @SuppressLint("MissingPermission")
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                if (isChecked){
                    bAdapter.enable()
                }else{
                    bAdapter.disable()
                }
            }
        })

    }
}