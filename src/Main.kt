fun main() {
    val dataList = mutableListOf<String>("tes")

    while (true) {
        println("\n=== MENU CRUD ===")
        println("1. Tambah Data")
        println("2. List Data")
        println("3. Edit Data")
        println("4. Hapus Data")
        println("5. Cari Data")
        println("6. Keluar")
        print("Pilih menu: ")

        when (readlnOrNull()?.toIntOrNull()) {
            1 -> tambahData(dataList)
            2 -> listData(dataList)
            3 -> editData(dataList)
            4 -> hapusData(dataList)
            5 -> showData(dataList)
            6 -> {
                println("Terima kasih!")
                break
            }
            else -> println("Pilihan tidak valid, coba lagi.")
        }
    }
}

fun tambahData(dataList: MutableList<String>) {
    print("Masukkan data: ")
    readlnOrNull()?.takeIf { it.isNotBlank() }?.let {
        dataList.add(it)
        println("Data berhasil ditambahkan!")
    } ?: println("Data tidak boleh kosong!")
}

fun listData(dataList: List<String>) {
    if (dataList.isEmpty()) {
        println("Belum ada data.")
    } else {
        println("\nDaftar Data:")
        dataList.forEachIndexed { index, data ->
            println("${index + 1}. $data")
        }
    }
}

fun editData(dataList: MutableList<String>) {
    listData(dataList)
    if (dataList.isNotEmpty()) {
        print("Pilih nomor data yang ingin diedit: ")
        val index = readlnOrNull()?.toIntOrNull()?.minus(1)

        if (index != null && index in dataList.indices) {
            print("Masukkan data baru: ")
            val newData = readlnOrNull()
            if (!newData.isNullOrBlank()) {
                dataList[index] = newData
                println("Data berhasil diperbarui!")
            } else {
                println("Data tidak boleh kosong!")
            }
        } else {
            println("Nomor tidak valid!")
        }
    }
}

fun hapusData(dataList: MutableList<String>) {
    listData(dataList)
    if (dataList.isNotEmpty()) {
        print("Pilih nomor data yang ingin dihapus: ")
        val index = readlnOrNull()?.toIntOrNull()?.minus(1)

        if (index != null && index in dataList.indices) {
            dataList.removeAt(index)
            println("Data berhasil dihapus!")
        } else {
            println("Nomor tidak valid!")
        }
    }
}

fun showData(dataList: List<String>) {
    print("Masukkan nama yang ingin dicari: ")
    val keyword = readlnOrNull()?.trim()

    if (!keyword.isNullOrBlank()) {
        val hasil = dataList.filter { it.contains(keyword, ignoreCase = true) }

        if (hasil.isNotEmpty()) {
            println("\nHasil Pencarian:")
            hasil.forEachIndexed { index, data ->
                println("${index + 1}. $data")
            }
        } else {
            println("Data tidak ditemukan.")
        }
    } else {
        println("Input tidak boleh kosong!")
    }
}

