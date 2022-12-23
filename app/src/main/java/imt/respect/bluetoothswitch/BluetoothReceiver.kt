package imt.respect.bluetoothswitch

import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class BluetoothReceiver : BroadcastReceiver() {

    private  val TAG = "BluetoothReceiver"

    override fun onReceive(context: Context, intent: Intent) {

        val action=intent.getAction()

        if (BluetoothAdapter.ACTION_STATE_CHANGED.equals(action)){
            if (intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, 1)==BluetoothAdapter.STATE_OFF){
                Log.d(TAG, "onReceive: off")
                Toast.makeText(context, "Bluetooth o'chirildi", Toast.LENGTH_SHORT).show()
            }
            if (intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, 1)==BluetoothAdapter.STATE_ON){
                Log.d(TAG, "onReceive: on")
                Toast.makeText(context, "Bluetooth yoqildi", Toast.LENGTH_SHORT).show()

            }
        }
    }
}