package br.com.szella.memoteca.model.entity;

import br.com.szella.memoteca.enums.ModeloEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Pensamento")
@Table(name = "pensamento")
public class PensamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pensamento")
    @SequenceGenerator(
            name = "pensamento",
            sequenceName = "pensamento_id_seq",
            allocationSize = 1,
            initialValue = 1)
    private Long id;
    private String conteudo;
    private String autoria;

    @Enumerated(EnumType.STRING)
    private ModeloEnum modeloEnum;
}
