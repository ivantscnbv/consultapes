package com.operacionespes.operacionespes.repository;

import com.operacionespes.operacionespes.dto.QueryContactosODCEDto;
import com.operacionespes.operacionespes.dto.QueryDireccionesODCEDto;
import com.operacionespes.operacionespes.dto.QueryRelacionArbolDto;
import com.operacionespes.operacionespes.entity.RelacionesArbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DireccionesyContactosRepository extends JpaRepository<RelacionesArbol,Integer> {

    // Consulta para obtener los ArbolId
    @Query("SELECT NEW com.operacionespes.operacionespes.dto.QueryRelacionArbolDto(ArbolId) " +
            "FROM RelacionesArbol " +
            "WHERE PersonaMoralId = :PersonaMoralId AND SubSectorId = :SubSectorId ")

    List<QueryRelacionArbolDto> obtenerArbolIds(@Param("PersonaMoralId") Integer PersonaMoralId,
                                                @Param("SubSectorId") Integer SubSectorId);

    @Query("SELECT NEW com.operacionespes.operacionespes.dto.QueryDireccionesODCEDto(a.DireccionId, " +
            "a.TipoDireccionId AS TipoDireccionId, " +
            "RTRIM(f.TipoDireccionNombre) AS TipoDireccionDescripcion, " +
            "RTRIM(a.DireccionCalle) AS CalleNumero, " +
            "RTRIM(a.DireccionCiudad) AS Ciudad, " +
            "a.DireccionCP AS CodigoPostal, " +
            "RTRIM(c.ColoniaNombreLargo) AS Colonia, " +
            "a.DireccionColonia AS ColoniaId, " +
            "RTRIM(d.MunicipioNombreLargo) AS DelOMup, " +
            "a.DireccionDelegacion AS delegacionMunicipioId, " +
            "RTRIM(e.EstadoPaisNombre) AS Estado, " +
            "a.EstadoPaisId, " +
            "RTRIM(b.PaisNombre) AS Pais, " +
            "a.PaisId, " +
            "RTRIM(a.DireccionTelefono) AS Telefono, " +
            "RTRIM(a.DireccionFax) AS Faxes, " +
            "es.EstadoId AS Activos) " +
            "FROM RelacionesDirecciones a, " +
            "Paises b, " +
            "Colonia c, " +
            "MunicipioDel d, " +
            "EstadoPais e, " +
            "TipoDireccion f, " +
            "Estados es " +
            "WHERE a.PaisId = b.PaisId " +
            "AND a.DireccionColonia = c.ColoniaId " +
            "AND a.DireccionDelegacion = c.MunicipioId " +
            "AND a.EstadoPaisId = c.EstadoMunicipioId " +
            "AND a.DireccionDelegacion = d.MunicipioId " +
            "AND a.EstadoPaisId = d.EstadoMunicipioId " +
            "AND a.EstadoPaisId = e.EstadoPaisId " +
            "AND a.PaisId = e.PaisId " +
            "AND a.TipoDireccionId = f.TipoDireccionId " +
            "AND es.EstadoId = 1 " +
            "AND a.RelacionesArbol_ArbolId = :ArbolId ")
    List<QueryDireccionesODCEDto> obtenerDireccionesyContactosQuery(@Param("ArbolId") Integer ArbolId);

    @Query("SELECT NEW com.operacionespes.operacionespes.dto.QueryContactosODCEDto(RTRIM (c.ContactoTitulo) AS Titulo, " +
            "RTRIM(c.ContactoNombre) AS Nombre, " +
            "RTRIM(c.ContactoPaterno) AS Paterno, " +
            "RTRIM(c.ContactoMaterno) AS Materno, " +
            "c.CargoId AS CargoId, " +
            "RTRIM(d.CargoNombre) AS CargoDescripcion) " +
            "FROM RelacionesContactos c JOIN " +
            "Cargos d ON (c.CargoId=d.CargoId) " +
            "JOIN RelacionesDirecciones rd ON rd.RelacionesArbol_ArbolId = c.ArbolId " +
            "WHERE " +
            "c.EstadoId = 1 AND " +
            "rd.EstadoId = 1 AND " +
            "rd.DireccionId= :DireccionId")

    List<QueryContactosODCEDto> obtenerContactosIdQuery(@Param("DireccionId") Integer DireccionId);
}
