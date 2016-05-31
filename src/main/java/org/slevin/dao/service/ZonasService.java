package org.slevin.dao.service;

import org.slevin.common.Zonas;
import org.slevin.dao.ZonasDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class ZonasService extends EntityService<Zonas> implements ZonasDao {

	
}

