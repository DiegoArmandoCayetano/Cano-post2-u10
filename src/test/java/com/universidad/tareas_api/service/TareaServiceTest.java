package com.universidad.tareas_api.service;

import com.universidad.tareas_api.entity.Tarea;
import com.universidad.tareas_api.repository.TareaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TareaServiceTest {

    @Mock
    TareaRepository repo;

    @InjectMocks
    TareaService service;

    @Test
    void crear_conTituloValido_guardaYRetorna() {
        Tarea t = new Tarea();
        t.setTitulo("Estudiar JUnit");

        when(repo.save(any())).thenReturn(t);

        assertThat(service.crear(t).getTitulo())
                .isEqualTo("Estudiar JUnit");

        verify(repo).save(t);
    }

    @Test
    void crear_conTituloVacio_lanzaException() {
        Tarea t = new Tarea();
        t.setTitulo(" ");

        assertThrows(IllegalArgumentException.class,
                () -> service.crear(t));

        verify(repo, never()).save(any());
    }

    @Test
    void buscarPorId_noExiste_lanzaException() {
        when(repo.findById(99L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class,
                () -> service.buscarPorId(99L));
    }
}