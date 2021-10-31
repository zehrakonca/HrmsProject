import React, { useState, useEffect } from "react";
import { Segment, Table, Checkbox, Button, Icon } from 'semantic-ui-react';
import JobAdvertisementService from "../../services/JobAdvertisementService";
import { Link} from "react-router-dom";

export default function UpdateJobAdvertisement() {
    const [jobAdvertisements, setJobAdvertisements] = useState([])
    const [openConfirmed, setOpenConfirmed] = useState(false);
    const [openUnconfirmed, setOpenUnconfirmed] = useState(false);

    useEffect(() => {
        let jobAdvertisementService = new JobAdvertisementService()
        jobAdvertisementService.getJobAdvertisementsByIdFalse().then(result => setJobAdvertisements(result.data.data))
    }, [])

    const handleModalConfirmed = (value) => {
        setOpenConfirmed(value)
        if (value == 1){
            window.location.reload();
        }
    }

    const handleModalConfirmed = (value) => {
        setOpenConfirmed(value)
        if (value == 2){
            window.location.reload();
        }
    }

    const handleJobAdvertisementConfirm = (jobAdvertisementId) => {
        jobAdvertisementService.UpdateJobAdvertisement(advertisementId);
    }
    return (
        <div>
            <Segment>
                <Segment inverted color="teal">
                    <Icon name="chess rook" size="large" />
                    browse passive job advertisements
                </Segment>
                <Segment>
                    <Table celled>
                        <Table.Header>
                            <Table.Row>
                                <Table.HeaderCell>Company Name</Table.HeaderCell>
                                <Table.HeaderCell>Advertisement Name</Table.HeaderCell>
                                <Table.HeaderCell>Sector</Table.HeaderCell>
                                <Table.HeaderCell>Job</Table.HeaderCell>
                                <Table.HeaderCell>Release Date</Table.HeaderCell>
                                <Table.HeaderCell>Application Date</Table.HeaderCell>
                                <Table.HeaderCell>Accept / Decline</Table.HeaderCell>
                            </Table.Row>
                        </Table.Header>
                        <Table.Body>
                            {jobAdvertisements.map((jobAdvertisement) => (
                                <Table.Row>
                                    <Table.Cell>{jobAdvertisement.employer?.companyName}</Table.Cell>
                                    <Table.Cell>
                                        <Link to={`/advertisements/${jobAdvertisement.advertisementId}`}>
                                            {jobAdvertisement.advertisementName}
                                        </Link>
                                    </Table.Cell>
                                    <Table.Cell>{jobAdvertisement.sector.sectorName}</Table.Cell>
                                    <Table.Cell>{jobAdvertisement.job.jobName}</Table.Cell>
                                    <Table.Cell>{jobAdvertisement.releaseDate}</Table.Cell>
                                    <Table.Cell>{jobAdvertisement.applicationDate}</Table.Cell>
                                    <Table.Cell>  </Table.Cell>
                                </Table.Row>
                            ))}
                        </Table.Body>

                    </Table>
                    <Button inverted color="green"> Save </Button>
                </Segment>
            </Segment>
        </div>
    )
}
