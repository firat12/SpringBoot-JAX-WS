package com.uab.unet.springbootsoapws.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "YBS_IL", schema = "KUGM")
@Getter
@Setter
public class YbsIl {

    @Id
    @GeneratedValue(generator = "ybs_il_seq", strategy = GenerationType.TABLE)
    @TableGenerator(name = "ybs_il_seq",table = "YBS_IL_SEQ",allocationSize = 1,schema = "KGUM")
    @Column(name = "ID")
    private Long id;

    @Column(name = "IL_KODU", unique = true)
    private String ilKodu;

    @Column(name = "AD",unique = true,nullable = false)
    private String ad;

    @Column(name = "BOLGE_KODU")
    private String bolgeKodu;

    @Column(name = "KULLANICI_ID")
    private Long kullaniciId;

    @Column(name = "KURUM_ID", nullable = false)
    private String kurumId;

    @Column(name = "BUYUKSEHIR")
    private String buyukSehir;

    @Column(name = "NUFUS")
    private Integer nufus;

    @Column(name = "PLAKA_KODU")
    private String plakaKodu;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ULKE_ID", nullable = false,
            foreignKey = @ForeignKey(name = "FK_YBS_IL_REFERENCE_SINIR_UL", value = ConstraintMode.CONSTRAINT))
    private SinirUlke ulke;
}
