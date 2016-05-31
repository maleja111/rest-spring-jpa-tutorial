package org.slevin.dao.service;

import org.slevin.common.Paises;
import org.slevin.dao.PaisesDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class PaisesService extends EntityService<Paises> implements PaisesDao {

	
}

