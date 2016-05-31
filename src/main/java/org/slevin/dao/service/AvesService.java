package org.slevin.dao.service;


import org.slevin.common.Aves;
import org.slevin.dao.AvesDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class AvesService extends EntityService<Aves> implements AvesDao {

	
}

