package com.example.kasir_natasya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val namapelanggan = findViewById<EditText>(R.id.editnamapelanggan)
        val namabarang = findViewById<EditText>(R.id.editnamabarang)
        val jumlahbeli = findViewById<EditText>(R.id.editjumlahbeli)
        val hargasatuan = findViewById<EditText>(R.id.editharga)
        val uangbayar = findViewById<EditText>(R.id.edituangbayar)
        val btnproses= findViewById<Button>(R.id.btnProses)
        val txtHargaTotal = findViewById<TextView>(R.id.txtHargaTotal)
        val txtuangkembali = findViewById<TextView>(R.id.txtUangKembali)
        val txtbonus = findViewById<TextView>(R.id.txtBonus)
        val txtketerangan = findViewById<TextView>(R.id.txtKeterangan)
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnproses.setOnClickListener{
            var hargabarang = Integer.parseInt(hargasatuan.text.toString())
            var jmlbarang = Integer.parseInt(jumlahbeli.text.toString())
            var hargatotal = hargabarang * jmlbarang
            var uangbayar = Integer.parseInt(uangbayar.text.toString())
            var Kembalian = uangbayar - hargatotal

            txtHargaTotal.text = "Harga Total Rp." + hargatotal
            txtuangkembali.text = "Kembalian: " + if (Kembalian<=0) "Tidak ada" else Kembalian

            if(hargatotal >= 200000) {
                txtbonus.text = "Bonus: Mouse"
            } else if (hargatotal >= 400000){
                txtbonus.text = "Bonus: Keyboard"
            } else if (hargatotal >= 600000){
                txtbonus.text ="Bonus: Hardisk"
            } else {
                txtbonus.text ="Bonus: Tidak ada"
            }

            if (Kembalian == 0){
                txtketerangan.text ="Keterangan: Uang pas"
            } else if (Kembalian >0){
                txtketerangan.text ="Keterangan: Menunggu kembalian"
            } else {
                txtketerangan.text ="Keterangan: Uang kurang" + abs(Kembalian)
            }
        }


        btnReset.setOnClickListener{
            namapelanggan.setText("")
            namabarang.setText("")
            jumlahbeli.setText("")
            hargasatuan.setText("")
            uangbayar.setText("")
            txtHargaTotal.text = "Harga total"
            txtuangkembali.text = "Kembalian"
            txtbonus.text = "Bonus:"
            txtketerangan.text = "Keterangan"
        }
    }
}