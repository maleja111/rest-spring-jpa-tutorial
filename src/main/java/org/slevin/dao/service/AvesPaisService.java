package org.slevin.dao.service;

import org.slevin.common.AvesPais;
import org.slevin.dao.AvesPaisDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class AvesPaisService extends EntityService<AvesPais> implements AvesPaisDao {

}
