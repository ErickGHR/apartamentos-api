package com.api.apartamentos.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.api.apartamentos.models.PropiedadModel;
import com.api.apartamentos.repositories.IPropiedadRepository;

@ExtendWith(MockitoExtension.class)
class PropiedadServiceTest {

    @Mock
    private IPropiedadRepository propiedadRepository;

    private PropiedadService service;

    @BeforeEach
    void setUp() {
        service = new PropiedadService(propiedadRepository);
    }

    @Test
    void buscaPropiedadesPorTipo() {
        PropiedadModel propiedad = new PropiedadModel();
        propiedad.setTipo("Departamento");
        when(propiedadRepository.findByTipoIgnoreCase("departamento"))
                .thenReturn(List.of(propiedad));

        List<PropiedadModel> resultado = service.getPropiedadesByTipo("departamento");

        assertEquals(1, resultado.size());
        assertEquals("Departamento", resultado.getFirst().getTipo());
    }

    @Test
    void buscaPropiedadesPorPropietario() {
        PropiedadModel propiedad = new PropiedadModel();
        propiedad.setTitulo("Loft del centro");
        when(propiedadRepository.findByPropietario_Id(4L))
                .thenReturn(List.of(propiedad));

        List<PropiedadModel> resultado = service.getPropiedadesByPropietario(4L);

        assertEquals(1, resultado.size());
        assertEquals("Loft del centro", resultado.getFirst().getTitulo());
    }
}
