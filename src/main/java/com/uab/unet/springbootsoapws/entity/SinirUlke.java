package com.uab.unet.springbootsoapws.entity;

import javax.persistence.*;

@Entity
@Table(name = "SINIR_ULKE",schema = "KUGM")
public class SinirUlke {

    @TableGenerator(name = "SINIR_ULKE_SEQ", allocationSize = 1,schema = "KUGM")
    @GeneratedValue(generator = "sinir_ulke_seq", strategy = GenerationType.TABLE)
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "ULKE_ADI", nullable = false)
    private String ulkeKodu;

    @Column(name = "ULKE_ADI", nullable = false)
    private String ulkeAdi;

    @Column(name = "PARALEL")
    private Integer paralel;

    @Column(name = "MERIDYEN")
    private Integer meridyen;

    @Column(name = "KITA_ID")
    private Integer kitaId;

    @Column(name = "DOSYA_VAR")
    private String dosyaVar;

    @Column(name = "ANLASMALI", nullable = false)
    private String anlasmali;

    @Column(name = "UBAK_KATSAYI", nullable = false)
    private Integer ubakKatsayi;

    @Column(name = "GUMRUK_ULKE_KODU", nullable = false)
    private String gumrukUlkeKodu;

    @Column(name = "KAPASITE_ORANI_B1", nullable = false)
    private Integer kapasiteOraniB1;

    @Column(name = "KAPASITE_ORANI_B3", nullable = false)
    private Integer kapasiteOraniB3;

    @Column(name = "KAPASITE_ORANI_IKILI", nullable = false)
    private Integer kapasiteOraniIkili;

    @Column(name = "KAPASITE_ORANI_ARIZI", nullable = false)
    private Integer kapasiteOraniArizi;

    @Column(name = "INTERBUS_UYE", nullable = false)
    private String interbusUye;

    @Column(name = "KAPASITE_ORANI_B2", nullable = false)
    private Integer kapasiteOraniB2;

    @Column(name = "TURU", nullable = false)
    private String turu;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "ulke", orphanRemoval = true)
    private YbsIl il;
}
