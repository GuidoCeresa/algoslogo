package it.algos.algoslogo

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(EventoService)
@Mock(Evento)
class EventoServiceTests {

    // utilizzo di un service con la businessLogic per l'importazione dei dati
    // il service NON viene iniettato automaticamente
    EventoService eventoService = new EventoService()

    void testGenerico() {
        //--database provvisorio per il test
        String generico = EventoService.GENERICO
        Evento.findOrCreateByNome(generico).save(failOnError: true)

        //--test
        def ottenuto
        def richiesto = Evento.findByNome(generico)

        ottenuto = eventoService.getGenerico()
        assert ottenuto != null
        assert ottenuto == richiesto
    }// fine del test

    void testNuovo() {
        //--database provvisorio per il test
        String nuovo = EventoService.NUOVO
        Evento.findOrCreateByNome(nuovo).save(failOnError: true)

        //--test
        def ottenuto
        def richiesto = Evento.findByNome(nuovo)

        ottenuto = eventoService.getNuovo()
        assert ottenuto != null
        assert ottenuto == richiesto
    }// fine del test

    void testModifica() {
        //--database provvisorio per il test
        String modifica = EventoService.MODIFICA
        Evento.findOrCreateByNome(modifica).save(failOnError: true)

        //--test
        def ottenuto
        def richiesto = Evento.findByNome(modifica)

        ottenuto = eventoService.getModifica()
        assert ottenuto != null
        assert ottenuto == richiesto
    }// fine del test

    void testCancella() {
        //--database provvisorio per il test
        String cancella = EventoService.CANCELLA
        Evento.findOrCreateByNome(cancella).save(failOnError: true)

        //--test
        def ottenuto
        def richiesto = Evento.findByNome(cancella)

        ottenuto = eventoService.getCancella()
        assert ottenuto != null
        assert ottenuto == richiesto
    }// fine del test

} // fine della classe di Test
