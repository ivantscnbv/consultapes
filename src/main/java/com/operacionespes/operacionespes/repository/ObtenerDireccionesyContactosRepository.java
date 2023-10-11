package com.operacionespes.operacionespes.repository;

import com.operacionespes.operacionespes.dto.QueryContactosODCEDto;
import com.operacionespes.operacionespes.dto.QueryDireccionesODCEDto;
import com.operacionespes.operacionespes.dto.QueryRelacionArbolDto;
import com.operacionespes.operacionespes.entity.RelacionesArbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObtenerDireccionesyContactosRepository extends JpaRepository<RelacionesArbol, Integer> {


    @Query(value = "SELECT NEW com.operacionespes.operacionespes.dto.QueryRelacionArbolDto(ra.ArbolId) " +
            "FROM RelacionesArbol ra " +
            "WHERE ra.PersonaMoralId = :PersonaMoralId " +
            "AND ra.SubSectorId = :SubSectorId")
    List<QueryRelacionArbolDto> queryRelacionArbol(@Param("PersonaMoralId") Integer PersonaMoralId,
                                                   @Param("SubSectorId") Integer SubSectorId);

    @Query(value = "SELECT NEW com.operacionespes.operacionespes.dto.QueryDireccionesODCEDto(" +
            "a.DireccionId, " +
            "a.TipoDireccionId as tipoDireccionId, " +
            "TRIM(f.TipoDireccionNombre) as tipoDireccionDescripcion, " +
            "TRIM(a.DireccionCalle) AS calleNumero, " +
            "TRIM(a.DireccionCiudad) AS Ciudad, " +
            "a.DireccionCP as codigoPostal, " +
            "TRIM(c.ColoniaNombreLargo) as Colonia, " +
            "a.DireccionColonia as ColoniaId, " +
            "TRIM(d.MunicipioNombreLargo) as DelOMup, " +
            "a.DireccionDelegacion as delegacionMunicipioId, " +
            "TRIM(e.EstadoPaisNombre) as Estado, " +
            "a.EstadoPaisId, " +
            "TRIM(b.PaisNombre) as Pais, " +
            "a.PaisId, " +
            "TRIM(a.DireccionTelefono) as Telefono, " +
            "TRIM(a.DireccionFax) as faxes, " +
            "es.EstadoId as Activos) " +
            "FROM RelacionesDirecciones a, Paises b, Colonia c, MunicipioDel d, EstadoPais e, TipoDireccion f, Estados es " +
            "WHERE a.PaisId = b.PaisId " +
            "    AND a.DireccionColonia = c.ColoniaId " +
            "    AND a.DireccionDelegacion = c.MunicipioId " +
            "    AND a.EstadoPaisId = c.EstadoMunicipioId " +
            "    AND a.DireccionDelegacion = d.MunicipioId " +
            "    AND a.EstadoPaisId = d.EstadoMunicipioId " +
            "    AND a.EstadoPaisId = e.EstadoPaisId " +
            "    AND a.PaisId = e.PaisId " +
            "    AND a.TipoDireccionId = f.TipoDireccionId " +
            "    AND es.EstadoId = 1 " +
            "    AND a.RelacionesArbol_ArbolId = :ArbolId")
    List<QueryDireccionesODCEDto> queryDireccionesODCE(Integer ArbolId);

    @Query(value = "SELECT NEW com.operacionespes.operacionespes.dto.QueryContactosODCEDto(" +
            "TRIM(c.ContactoTitulo) AS Titulo, " +
            "TRIM(c.ContactoNombre) AS Nombre, " +
            "TRIM(c.ContactoPaterno) AS paterno, " +
            "TRIM(c.ContactoMaterno) AS materno, " +
            "c.CargoId AS cargoId, " +
            "TRIM(d.CargoNombre) AS cargoDescripcion) " +
            "FROM RelacionesContactos c " +
            "JOIN Cargos d ON c.CargoId = d.CargoId " +
            "JOIN RelacionesDirecciones rd ON rd.RelacionesArbol_ArbolId = c.ArbolId " +
            "WHERE c.EstadoId = 1 " +
            "AND rd.EstadoId = 1 " +
            "AND rd.DireccionId = :DireccionId")
    List<QueryContactosODCEDto> queryContactosODCE(Integer DireccionId);
}
