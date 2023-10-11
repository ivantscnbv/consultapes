/*package com.operacionespes.operacionespes.repository;

import com.operacionespes.operacionespes.dto.QueryContactosODCEDto;
import com.operacionespes.operacionespes.dto.QueryDireccionesODCEDto;
import com.operacionespes.operacionespes.entity.RelacionesArbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DireccionesyContactosRepository extends JpaRepository<RelacionesArbol,Integer> {


    // Consulta para obtener los ArbolId
    @Query( "SELECT ArbolId " +
            "FROM RelacionesArbol " +
            "WHERE PersonaMoralId = :PersonaMoralId AND SubSectorId = :SubSectorId ")
    List<Integer> obtenerArbolIds(@Param("PersonaMoralId") Integer personaMoralId,
                                  @Param("SubSectorId") Integer subSectorId);

    @Query("SELECT NEW com.operacionespes.operacionespes.dto.QueryDireccionesODCEDto(" +
            "a.DireccionId, " +
            "a.TipoDireccionId, " +
            "RTRIM(t1_0.TipoDireccionNombre), " +
            "RTRIM(a.DireccionCalle), " +
            "RTRIM(a.DireccionCiudad), " +
            "a.DireccionCP, " +
            "RTRIM(c1_0.ColoniaNombreLargo), " +
            "a.DireccionColonia, " +
            "RTRIM(m1_0.MunicipioNombreLargo), " +
            "a.DireccionDelegacion, " +
            "RTRIM(e1_0.EstadoPaisNombre), " +
            "a.EstadoPaisId, " +
            "RTRIM(p1_0.PaisNombre), " +
            "a.PaisId, " +
            "RTRIM(a.DireccionTelefono), " +
            "RTRIM(a.DireccionFax), " +
            "e2_0.EstadoId) " +
            "FROM RelacionesDirecciones a, Paises p1_0, Colonia c1_0, " +
            "MunicipioDel m1_0, EstadoPais e1_0, TipoDireccion t1_0, Estados e2_0 " +
            "WHERE a.PaisId = p1_0.PaisId " +
            "AND a.DireccionColonia = c1_0.ColoniaId " +
            "AND a.DireccionDelegacion = c1_0.MunicipioId " +
            "AND a.EstadoPaisId = c1_0.EstadoMunicipioId " +
            "AND a.DireccionDelegacion = m1_0.MunicipioId " +
            "AND a.EstadoPaisId = m1_0.EstadoMunicipioId " +
            "AND a.EstadoPaisId = e1_0.EstadoPaisId " +
            "AND a.PaisId = e1_0.PaisId " +
            "AND a.TipoDireccionId = t1_0.TipoDireccionId " +
            "AND e2_0.EstadoId = 1 " +
            "AND a.RelacionesArbol_ArbolId = :ArbolId")
    List<QueryDireccionesODCEDto> obtenerDireccionesQuery(@Param("ArbolId") Integer ArbolId);


    @Query( "SELECT NEW com.operacionespes.operacionespes.dto.QueryContactosODCEDto(RTRIM(c.ContactoTitulo) AS Titulo, " +
            "RTRIM(c.ContactoNombre) AS Nombre, " +
            "RTRIM(c.ContactoPaterno) AS paterno, " +
            "RTRIM(c.ContactoMaterno) AS materno, " +
            "c.CargoId as cargoId, " +
            "RTRIM(d.CargoNombre) AS cargoDescripcion) " +
            "FROM RelacionesContactos c JOIN " +
            "Cargos d ON (c.CargoId=d.CargoId) " +
            "JOIN RelacionesDirecciones rd ON rd.RelacionesArbol_ArbolId = c.ArbolId " +
            "WHERE " +
            "c.EstadoId=1 AND " +
            "rd.EstadoId = 1 AND " +
            "rd.DireccionId= :DireccionId ")

    List<QueryContactosODCEDto> obtenerContactosIdQuery(@Param("DireccionId") Integer DireccionId);
}*/

