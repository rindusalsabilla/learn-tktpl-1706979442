package id.ac.ui.cs.mobileprogramming.rindu.mylab

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import id.ac.ui.cs.mobileprogramming.rindu.mylab.databinding.FragmentBuildingListBinding

import java.util.ArrayList

class BuildingListFragment : Fragment() {
    private var binding: FragmentBuildingListBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_building_list, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        val list = ArrayList<Item>()
        list.add(
            Item(
                "Tembok Besar China",
                "Lokasi: China",
                "Salah satu bangunan buatan manusia terpanjang yang pernah dibangun di dunia adalah Tembok Besar China. Bangunan ini dibangun oleh kaisar Qin Shi Guang untuk mempertahankan serangan dari suku Yayun Kuno. "
            )
        )
        list.add(
            Item(
                "Piramida Agung Giza",
                "Lokasi: Mesir",
                "Piramida Agung Giza merupakan salah satu dari tujuh keajaiban dunia. Piramida ini dibangun antara 2560 SM hingga 2540 SM sebagai tempat peristirahatan terakhir Firaun. \n" +
                        "Selain itu, Piramida Agung Giza juga menjadi satu-satunya piramida Mesir yang memiliki jalur naik dan turun. Diperkirakan sekitar 2,3 juta balok batu digunakan untuk membangun piramida tersebut."
            )
        )
        list.add(
            Item(
                "Stonehenge",
                "Lokasi: Inggris",
                "Stonehenge merupakan monumen batu prasejarah besar yang terletak di kota Salisbury, Inggris. Para arkeolog memperkirakan bahwa monumen ini dibangun sebelum 4.000 - 5.000 tahun lalu. Stonehenge juga mewakili keelokan arsitektur nenek moyang yang hidup pada waktu itu. "
            )
        )
        list.add(
            Item(
                "Kolosseum",
                "Lokasi: Italia",
                "Kolosseum merupakan monumen paling mengesankan dari Kekaisaran Romawi yang berupa area Gladiator. Dibangun oleh Vespasian, tempat pertunjukan yang merupakan amfiteater terbesar di dunia itu berbentuk elips dan termasuk dalam salah satu keajaiban dunia. Kolosseum sendiri mampu menampung hingga 50 ribu penonton."
            )
        )
        list.add(
            Item(
                "Taj Mahal",
                "Lokasi: India",
                "Taj Mahal, monumen bersejarah dengan desain arsitektur Mughal di India. Taj Mahal yang berarti Mahkota Istana dalam bahasa Arab dianggap sebagai simbol cinta paling ikonik. \n" +
                        "Taj Mahal sendiri mengambil kombinasi gaya arsitektur Mughal, Ottoman Turki, Persia, Islam, dan India yang membuatnya ditetapkan sebagai situs warisan dunia oleh UNESCO pada tahun 1983."
            )
        )
        list.add(
            Item(
                "Petra",
                "Lokasi: Yordania",
                "Berada di kota Ma'an, Yordania, Petra memiliki sebutan lain, di antaranya yaitu Kota Mawar. Ada 800 monumen di Petra, yang sebagiannya mewakili perpaduan gaya arsitektur batu-batuan Nabatia dan Helenistis. Bebatuan tersebut disusun hingga membentuk sebuah dinding yang kemudian diyakini di dalamnya terdapat tiga makam yang berasal dari Kerajaan besar di Yordania."
            )
        )
        list.add(
            Item(
                "Candi Borobudur",
                "Lokasi: Candi Borobudur",
                "Menjadi candi Buddha terbesar di dunia, Candi Borobudur merupakan bangunan bersejarah lainnya yang patut untuk dikunjungi. Berdiri di area seluas 1.900 meter persegi, Candi Borobudur diperkirakan dibangun antara abad 8 dan 9."
            )
        )

        val adapter = RecyclerViewAdapter(list, viewModel)
        binding!!.recyclerView.adapter = adapter
    }
}
