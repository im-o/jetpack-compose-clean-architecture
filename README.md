![jetshopee-compose](https://user-images.githubusercontent.com/22957498/210045071-7440c552-bc2c-4c68-9d12-ae668ec187db.gif)

<div class="dcd-tabs my-4">
    <ul class="nav nav-pills mb-3 dcd-tabs__label-container" id="guidance-tab" role="tablist" style="display: list-item">
        <li class="nav-item" style="display: inline-block">
            <a class="nav-link dcd-ghost dcd-btn active show" id="pills-pengantar-tab" data-toggle="pill" href="#pills-pengantar" role="tab" aria-controls="pills-pengantar" aria-selected="true"> Pengantar </a>
        </li>
        <li class="nav-item" style="display: inline-block">
            <a class="nav-link  dcd-ghost dcd-btn show" id="pills-kriteria-tab" data-toggle="pill" href="#pills-kriteria" role="tab" aria-controls="pills-kriteria" aria-selected="false"> Kriteria </a>
        </li>
        <li class="nav-item" style="display: inline-block">
            <a class="nav-link  dcd-ghost dcd-btn show" id="pills-kriteria-opsional-tab" data-toggle="pill" href="#pills-kriteria-opsional" role="tab" aria-controls="pills-kriteria-opsional" aria-selected="false"> Kriteria Opsional </a>
        </li>
        <li class="nav-item" style="display: inline-block">
            <a class="nav-link  dcd-ghost dcd-btn show" id="pills-penilaian-tab" data-toggle="pill" href="#pills-penilaian" role="tab" aria-controls="pills-penilaian" aria-selected="false"> Penilaian </a>
        </li>
        <li class="nav-item" style="display: inline-block">
            <a class="nav-link  dcd-ghost dcd-btn" id="pills-lainnya-tab" data-toggle="pill" href="#pills-lainnya" role="tab" aria-controls="pills-lainnya" aria-selected=""> Lainnya </a>
        </li>
    </ul>
    <div class="tab-content academy-tutorial-content content--prettify-light js-content-prettify fr-view" id="pills-tabContent">
        <div class="tab-pane fade active show" id="pills-pengantar" role="tabpanel" aria-labelledby="pills-pengantar-tab">
            <p dir="ltr">Selamat, akhirnya Anda telah sampai di penghujung pembelajaran. Berikut beberapa hal yang sudah Anda lewati.</p>
            <ul>
                <li dir="ltr">Berkenalan dengan Jetpack Compose, mengetahui alasan mempelajarinya, dan tools untuk membuatnya.</li>
                <li dir="ltr">Memahami paradigma dan konsep dasar dari Jetpack Compose, seperti declarative programming, composable function, dan recomposition.</li>
                <li dir="ltr">Belajar tentang macam-macam layout dan modifier untuk membangun UI di Compose. Serta, belajar juga konsep Slot based layout yang membuat UI aplikasi bersifat reusable.</li>
                <li dir="ltr">Melihat bagaimana mengatur State pada Jetpack Compose, mengimplementasikan State Hoisting untuk membuat komponen Stateless, memahami berbagai macam Side Effect API, dan mengetahui macam-macam lokasi manajemen state.</li>
                <li dir="ltr">Membuat aplikasi yang lebih kompleks dengan menampilkan data list yang banyak secara dinamis dan efisien menggunakan Lazy List.&nbsp;</li>
                <li dir="ltr">Mengimplementasikan navigasi antara halaman pada Jetpack Compose.</li>
                <li dir="ltr">Memahami cara melakukan testing pada Jetpack Compose.</li>
                <li dir="ltr">Mengetahui cara menghubungkan Jetpack Compose dengan layout XML dan sebaliknya.</li>
            </ul>
            <p dir="ltr">Untuk bisa lulus dan mendapatkan sertifikat dari akademi ini, Anda harus mengerjakan tugas, yakni membuat aplikasi dengan tema bebas menggunakan Compose sesuai kriteria yang tertera. Anda juga bisa meniru UI aplikasi yang sudah ada di PlayStore. Tim Reviewer akan memeriksa pekerjaan Anda dan memberikan reviu pada aplikasi yang Anda buat. <br>
                <br>
            </p>
        </div>
        <div class="tab-pane fade" id="pills-kriteria" role="tabpanel" aria-labelledby="pills-kriteria-tab">
            <p dir="ltr">Fitur yang harus ada pada aplikasi:</p>
            <ol>
                <li dir="ltr">
                    <p dir="ltr">
                        <strong>Halaman List <br>
                        </strong>
                    </p>
                    <ul>
                        <li dir="ltr">
                            <p dir="ltr">Menampilkan data dalam format List dengan jumlah minimal 10 item yang berbeda. Gunakanlah LazyList/LazyGrid untuk menyusun datanya.&nbsp;</p>
                        </li>
                        <li dir="ltr">
                            <p dir="ltr">Memunculkan halaman detail ketika salah satu item ditekan.&nbsp;</p>
                        </li>
                    </ul>
                </li>
                <li dir="ltr">
                    <p dir="ltr">
                        <strong>Halaman Detail <br>
                        </strong>
                    </p>
                    <ul>
                        <li dir="ltr">
                            <p dir="ltr">Menampilkan gambar dan informasi yang relevan pada halaman detail.&nbsp;</p>
                        </li>
                        <li dir="ltr">
                            <p dir="ltr">Informasi yang relevan mencakup kesamaan informasi yang ditampilkan pada halaman utama dengan halaman detail.</p>
                            <ul>
                                <li dir="ltr">
                                    <p dir="ltr">Terdapat judul dan gambar yang sesuai dengan list</p>
                                </li>
                                <li dir="ltr">
                                    <p dir="ltr">Terdapat informasi tambahan yang tidak sama dengan list</p>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li dir="ltr">
                    <p dir="ltr">
                        <strong>Halaman About <br>
                        </strong>
                    </p>
                    <ul>
                        <li dir="ltr">
                            <p dir="ltr">Menampilkan foto diri, nama, dan email yang terdaftar di Dicoding.</p>
                        </li>
                        <li dir="ltr">
                            <p dir="ltr">Dalam mengakses halaman about, pastikan terdapat tombol yang bisa digunakan untuk mengakses halamannya. Untuk cara mengaksesnya, Anda bisa mengimplementasikan:</p>
                            <ul>
                                <li dir="ltr">
                                    <p dir="ltr">Dengan menambahkan elemen View khusus (bisa option menu, tombol, atau tab) yang mengandung contentDescription “about_page”</p>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ol>
        </div>
        <div class="tab-pane fade" id="pills-kriteria-opsional" role="tabpanel" aria-labelledby="pills-kriteria-opsional-tab">
            <p dir="ltr">Selain kriteria utama, terdapat kriteria opsional yang yang dapat Anda penuhi agar mendapat nilai yang lebih tinggi.</p>
            <ol>
                <li dir="ltr">
                    <p dir="ltr">
                        <strong>Fitur Pencarian <br>
                        </strong>
                    </p>
                    <ul>
                        <li dir="ltr">
                            <p dir="ltr">Aplikasi memiliki fitur pencarian berdasarkan kata kunci yang dimasukkan, dengan ketentuan:</p>
                            <ul>
                                <li dir="ltr">
                                    <p dir="ltr">Jika kolom pencarian tidak kosong, maka aplikasi hanya menampilkan data yang judulnya mengandung kata kunci yang dimasukkan.</p>
                                </li>
                                <li dir="ltr">
                                    <p dir="ltr">Jika kolom pencariannya kosong, maka aplikasi menampilkan seluruh data.</p>
                                </li>
                            </ul>
                        </li>
                        <li dir="ltr">
                            <p dir="ltr">Memanfaatkan ViewModel dalam membangun fitur catatan.</p>
                        </li>
                    </ul>
                </li>
                <li dir="ltr">
                    <p dir="ltr">
                        <strong>Fitur Menambah &amp; Menghapus Data <br>
                        </strong>
                    </p>
                    <ul>
                        <li dir="ltr">
                            <p dir="ltr">Aplikasi memiliki fitur untuk menambah dan menghapus data. Berikut beberapa skenario yang bisa diimplementasikan..</p>
                            <ul>
                                <li dir="ltr">
                                    <p dir="ltr">Menambah &amp; menghapus data utama.</p>
                                </li>
                                <li dir="ltr">
                                    <p dir="ltr">Menambah &amp; menghapus data favorit.</p>
                                </li>
                                <li dir="ltr">
                                    <p dir="ltr">Menambah &amp; menghapus data keranjang.</p>
                                </li>
                                <li dir="ltr">
                                    <p dir="ltr">Skenario sejenisnya.</p>
                                </li>
                            </ul>
                        </li>
                        <li dir="ltr">
                            <p dir="ltr">Teknik penyimpanan cukup menggunakan fake List. Jika ingin menggunakan database asli atau API pun tidak masalah.</p>
                        </li>
                        <li dir="ltr">
                            <p dir="ltr">Jika data kosong, menampilkan informasi bahwa data kosong.</p>
                        </li>
                    </ul>
                </li>
            </ol>
            <p dir="ltr">Berikut kerangka tampilan yang bisa Anda gunakan sebagai referensi:</p>
            <p dir="ltr">
                <img src="https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/original/academy/dos:33f792ba12b938a7c5047aab0f3fc27520221025172956.jpeg" width="602" height="740" class="fr-fic fr-dii" alt="dos:33f792ba12b938a7c5047aab0f3fc27520221025172956.jpeg">
            </p>
            <p dir="ltr">&nbsp;</p>
        </div>
        <div class="tab-pane fade" id="pills-penilaian" role="tabpanel" aria-labelledby="pills-penilaian-tab">
            <p dir="ltr">Submission Anda akan dinilai oleh reviewer dengan&nbsp;skala 1-5&nbsp;berdasarkan dari parameter yang ada.</p>
            <p dir="ltr">Anda dapat menerapkan beberapa&nbsp;saran&nbsp;di bawah ini untuk mendapatkan nilai tinggi, berikut sarannya:</p>
            <ul>
                <li>Menerapkan tampilan aplikasi yang sesuai standar. Di mana kriterianya adalah: <ul>
                        <li dir="ltr">Memiliki width, height, dan padding yang sesuai.</li>
                        <li dir="ltr">Komponen tidak saling bertumpuk.</li>
                        <li dir="ltr">Penggunaan komponen sesuai dengan fungsinya.</li>
                        <li dir="ltr">Penggunaan warna yang sesuai.</li>
                    </ul>
                </li>
                <li>Menuliskan kode dengan baik sesuai best-practice: <ul>
                        <li>Tidak membuat komponen yang tidak diperlukan.</li>
                        <li dir="ltr">Memecah UI menjadi komponen sekecil mungkin (sesuai tanggung jawabnya).</li>
                        <li dir="ltr">Menambahkan default Modifier pada setiap komponen.</li>
                        <li>Tidak menggunakan object sekaligus sebagai parameter, tetapi cukup yang dibutuhkan saja.</li>
                        <li dir="ltr">Menggunakan key untuk LazyList/LazyGrid.</li>
                        <li dir="ltr">Memanajemen state dengan tepat.</li>
                    </ul>
                </li>
                <li>Membuat fitur pencarian.</li>
                <li dir="ltr">Membuat fitur menambahkan &amp; menghapus data.</li>
                <li dir="ltr">Membuat end-to-end testing untuk memeriksa fungsional seluruh halaman, baik positif case maupun negative case.</li>
            </ul>
            <p dir="ltr">Detail penilaian submission:&nbsp;</p>
            <div class="dcd-rounded-8 border-gray-200 mb-5 mt-3">
                <div class="d-flex flex-sm-row flex-column p-3">
                    <img src="https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/original/submission-rating-badge/rating-default-1.png" title="rating-default-1" width="96" height="96" id="rating-default-0" alt="rating-default-1" class="modal-dialog-zoom-disabled border-0">
                    <img src="https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/original/submission-rating-badge/rating-dark-1.png" title="rating-dark-1" width="96" height="96" id="rating-dark-0" alt="rating-dark-1" class="modal-dialog-zoom-disabled border-0">
                    <p class="my-auto ml-3">Semua ketentuan terpenuhi, tetapi terdapat indikasi plagiat yaitu dengan menggunakan project orang lain dan hanya merubah kontennya saja.</p>
                </div>
                <hr class="m-0 border-gray-200">
                <div class="d-flex flex-sm-row flex-column p-3">
                    <img src="https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/original/submission-rating-badge/rating-default-2.png" title="rating-default-2" width="96" height="96" id="rating-default-1" alt="rating-default-2" class="modal-dialog-zoom-disabled border-0">
                    <img src="https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/original/submission-rating-badge/rating-dark-2.png" title="rating-dark-2" width="96" height="96" id="rating-dark-1" alt="rating-dark-2" class="modal-dialog-zoom-disabled border-0">
                    <p class="my-auto ml-3">Semua ketentuan terpenuhi, tetapi terdapat kekurangan pada tampilan aplikasi.</p>
                </div>
                <hr class="m-0 border-gray-200">
                <div class="d-flex flex-sm-row flex-column p-3">
                    <img src="https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/original/submission-rating-badge/rating-default-3.png" title="rating-default-3" width="96" height="96" id="rating-default-2" alt="rating-default-3" class="modal-dialog-zoom-disabled border-0">
                    <img src="https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/original/submission-rating-badge/rating-dark-3.png" title="rating-dark-3" width="96" height="96" id="rating-dark-2" alt="rating-dark-3" class="modal-dialog-zoom-disabled border-0">
                    <p class="my-auto ml-3">Semua ketentuan terpenuhi, tetapi hanya mengikuti apa yang ada pada modul.</p>
                </div>
                <hr class="m-0 border-gray-200">
                <div class="d-flex flex-sm-row flex-column p-3">
                    <img src="https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/original/submission-rating-badge/rating-default-4.png" title="rating-default-4" width="96" height="96" id="rating-default-3" alt="rating-default-4" class="modal-dialog-zoom-disabled border-0">
                    <img src="https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/original/submission-rating-badge/rating-dark-4.png" title="rating-dark-4" width="96" height="96" id="rating-dark-3" alt="rating-dark-4" class="modal-dialog-zoom-disabled border-0">
                    <p class="my-auto ml-3">Semua ketentuan terpenuhi dan menerapkan tiga saran di atas.</p>
                </div>
                <hr class="m-0 border-gray-200">
                <div class="d-flex flex-sm-row flex-column p-3">
                    <img src="https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/original/submission-rating-badge/rating-default-5.png" title="rating-default-5" width="96" height="96" id="rating-default-4" alt="rating-default-5" class="modal-dialog-zoom-disabled border-0">
                    <img src="https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/original/submission-rating-badge/rating-dark-5.png" title="rating-dark-5" width="96" height="96" id="rating-dark-4" alt="rating-dark-5" class="modal-dialog-zoom-disabled border-0">
                    <p class="my-auto ml-3">Semua ketentuan terpenuhi dan menerapkan semua saran di atas.</p>
                </div>
            </div>
            <blockquote>
                <p dir="ltr">
                    <strong>Catatan:</strong>
                    <br>Jika submission Anda ditolak, tidak ada penilaian. Kriteria penilaian bintang di atas hanya berlaku jika submission Anda lulus.
                </p>
            </blockquote>
            <p dir="ltr">&nbsp;</p>
        </div>
        <div class="tab-pane fade " id="pills-lainnya" role="tabpanel" aria-labelledby="pills-lainnya-tab">
            <h3 dir="ltr">Submission yang Tidak Sesuai Kriteria</h3>
            <p dir="ltr">Jika submission Anda tidak sesuai dengan kriteria, maka akan ditolak oleh reviewer, berikut poin-poin yang harus diperhatikan:</p>
            <ul>
                <li dir="ltr">Aplikasi utama tidak dibuat dengan Jetpack Compose.</li>
                <li dir="ltr">Tidak bisa berpindah ke&nbsp;halaman detail&nbsp;ketika salah satu item ditekan.</li>
                <li dir="ltr">Gambar tidak berhasil ditampilkan.</li>
                <li dir="ltr">Informasi yang ditampilkan pada daftar ataupun detail tidak relevan.</li>
                <li dir="ltr">Tidak menampilkan&nbsp;foto diri,&nbsp;nama&nbsp;,dan&nbsp;email&nbsp;yang terdaftar di Dicoding pada&nbsp;halaman about.</li>
                <li dir="ltr">Aplikasi force closed.</li>
                <li dir="ltr">Melakukan kecurangan seperti tindakan plagiarisme.</li>
            </ul>
            <p dir="ltr">&nbsp;</p>
            <h3 dir="ltr">Forum Diskusi</h3>
            <p dir="ltr">Jika mengalami kesulitan, Anda bisa menanyakan langsung ke forum diskusi. <a href="https://www.dicoding.com/academies/445/discussions?query=&amp;query_criteria=&amp;sort=&amp;sort_direction=&amp;title=&amp;tutorial=1247&amp;keywords=&amp;creator=">https://www.dicoding.com/academies/445/discussions</a>. </p>
            <p dir="ltr">&nbsp;</p>
            <h3 dir="ltr">Ketentuan Berkas Submission</h3>
            <p dir="ltr">Beberapa poin yang perlu diperhatikan ketika mengirimkan berkas submission:</p>
            <ul>
                <li dir="ltr">Menggunakan Android Studio.</li>
                <li dir="ltr">Menggunakan bahasa pemrograman&nbsp;Kotlin.</li>
                <li dir="ltr">Dalam aplikasi yang dikirimkan, pastikan untuk dapat dibuka dan terhindar dari crash.</li>
            </ul>
            <p dir="ltr">&nbsp;</p>
            <h3 dir="ltr">Ketentuan Proses Review</h3>
            <p dir="ltr">Beberapa hal yang perlu Anda ketahui mengenai proses review:</p>
            <ul>
                <li dir="ltr">Tim penilai akan mengulas submission Anda dalam waktu selambatnya 3 (tiga) hari kerja (tidak termasuk Sabtu, Minggu, dan hari libur nasional).</li>
                <li dir="ltr">Tidak disarankan untuk melakukan&nbsp;submit berkali-kali&nbsp;karena akan memperlama proses penilaian.</li>
                <li dir="ltr">Anda akan mendapat notifikasi hasil pengumpulan submission Anda via email, atau Anda dapat mengecek status submission pada akun Dicoding Anda.</li>
            </ul>
        </div>
    </div>
</div>
