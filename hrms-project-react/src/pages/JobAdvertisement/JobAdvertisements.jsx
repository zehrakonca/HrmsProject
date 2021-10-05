import React, { useState, useEffect } from "react";
import { Link, NavLink } from "react-router-dom";
import { Segment, Item, Button, Icon } from 'semantic-ui-react'
import company from '../../../src/img/company.png';
import JobAdvertisementService from "../../services/JobAdvertisementService";

export default function JobAdvertisements() {
  const [jobAdvertisements, setJobAdvertisements] = useState([])

  useEffect(() => {
    let jobAdvertisementService = new JobAdvertisementService()
    jobAdvertisementService.getJobAdvertisements().then(result => setJobAdvertisements(result.data.data))
  }, [])

  return (
    <div>
      <Segment color='teal'>
        {jobAdvertisements.map((jobAdvertisement) => (
          <Item.Group dividing>
            <Item key={jobAdvertisement.advertisementId}>
              <Item.Image src={company} size="small" />
              <Item.Content>
                <Item.Header as='a' floated='left'>
                  <Link to={`/advertisements/${jobAdvertisement.advertisementId}`}>
                    {jobAdvertisement.advertisementName}
                  </Link>
                </Item.Header>
                <Item.Meta floated='left'>
                  <span>{jobAdvertisement.sector.sectorName}, {jobAdvertisement.city.cityName}</span>
                </Item.Meta>
                <Item.Description floated='left'>{jobAdvertisement.jobDescription}</Item.Description>
                <Item.Extra>
                  <Button color="teal" floated='right' as={NavLink} to="/jobDetail">
                    <Link to={`/advertisements/${jobAdvertisement.advertisementId}`}>
                      examine!
                      <Icon name='right chevron' />
                    </Link>
                  </Button>
                </Item.Extra>
              </Item.Content>
            </Item>
          </Item.Group>
        ))}
      </Segment>
    </div>
  );
}