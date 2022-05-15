package domain

import domain.criterios.CriterioDeAprovacao

class AnalisadorDeAprovacao {

    private lateinit var criterio: CriterioDeAprovacao

    fun defineCriterio(criterio: CriterioDeAprovacao) {
        this.criterio = criterio
    }

    fun fechaBoletim(boletim: Boletim): BoletimFechado{
        val mediaFinal = criterio.mediaFinal(boletim)
        val foiAprovado = criterio.estaAprovado(boletim)

        val boletimFechado = BoletimFechado(boletim.mediaEPs,
            boletim.mediaMiniEPs,
            mediaFinal,
            foiAprovado
        )

        return boletimFechado
    }

}