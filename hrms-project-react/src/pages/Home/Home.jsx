import React, { useState, useEffect } from 'react'
import { Container, Header, Search, Grid, Image, Segment, List } from 'semantic-ui-react';
import { Link } from "react-router-dom";
import bannerPicture from '../../img/meeting1.jpg';
import avatar from '../../img/avatar.png';
import companyAvatar from '../../img/company.png';
import JobAdvertisementService from "../../services/JobAdvertisementService";
import SectorService from "../../services/SectorService";
import JobService from "../../services/JobService";

export default function Home() {
    const [jobAdvertisements, setJobAdvertisements] = useState([])
    const [sectors, setSectors] = useState([]);
    const [jobs, setJobs] = useState([]);

    useEffect(() => {
        let jobAdvertisementService = new JobAdvertisementService()
        jobAdvertisementService.getJobAdvertisements().then(result => setJobAdvertisements(result.data.data))
    }, [])

    useEffect(() => {
        let sectorService = new SectorService()
        sectorService.getAllSectors().then(result => setSectors(result.data.data))
    }, [])

    useEffect(() => {
        let jobService = new JobService()
        jobService.getAllJobs().then(result => setJobs(result.data.data))
    }, [])


    return (
        <div>
            <Grid>
                <Grid.Row columns={2} only="large screen">
                    <Grid.Column columns={7}>
                        <Container className="container">
                            <Header
                                as='h1'
                                content='Imagine-a-Find-Job'
                                color="grey"
                            />
                            <Header
                                as='h2'
                                content='Do whatever you want when you want to.'
                                color="grey"
                            />
                            <Search size="huge" placeholder='Write the job you are looking for.' />
                        </Container>
                        <Segment>
                            <Header as='h4' color='teal'>
                                Today's new job!
                            </Header>
                            <List divided>
                                {jobAdvertisements.map((jobAdvertisement) => (
                                    <List.Item>
                                        <Image src={companyAvatar} size="tiny" />
                                        <List.Content>
                                            <List.Header as='a'>
                                                <Link to={`/advertisements/${jobAdvertisement.advertisementId}`}>
                                                    {jobAdvertisement.employer?.companyName}
                                                </Link>
                                            </List.Header>
                                            <List.Header as='a'>
                                                 <Link to={`/advertisements/${jobAdvertisement.advertisementId}`}>
                                                {jobAdvertisement.advertisementName}
                                                </Link>
                                                </List.Header>
                                            <List.Description as='a'> {jobAdvertisement.city?.cityName}</List.Description>
                                        </List.Content>
                                    </List.Item>
                                ))}
                            </List>
                        </Segment>
                    </Grid.Column>
                    <Grid.Column columns={8}>
                        <Image src={bannerPicture} size="large" color="grey" floated />
                    </Grid.Column>
                </Grid.Row>
            </Grid>
            <Segment style={{ paddingBottom: '6em', paddingTop: '5em' }}>
                <Grid celled='internally' columns='equal' stackable>
                    <Grid.Row textAlign='center'>
                        <Grid.Column style={{ paddingBottom: '5em', paddingTop: '5em' }}>
                            <Header as='h3' style={{ fontSize: '2em' }} color="grey">
                                "How could you find job?"
                            </Header>
                            <p style={{ fontSize: '1.33em' }} color="grey">That is what they all say about us</p>
                        </Grid.Column>
                        <Grid.Column style={{ paddingBottom: '5em', paddingTop: '5em' }}>
                            <Header as='h4' style={{ fontSize: '2em' }} color="grey">
                                "I can't believe i find job two years ago. But I'm senior developer now."
                            </Header>
                            <p style={{ fontSize: '1.33em' }} color="grey">
                                <Image src={avatar} avatar />
                                <b>Nan</b> Chief Fun Officer Acme Toys
                            </p>
                        </Grid.Column>
                    </Grid.Row>
                </Grid>
            </Segment>
            <Grid columns={3} divided>
                <Grid.Row stretched>
                    <Grid.Column>
                        <Header color="teal">job postings by industry</Header>
                        <List>
                            {sectors.map((sector) => (
                                <List.Item>{sector.sectorName}</List.Item>
                            ))}
                        </List>
                    </Grid.Column>
                    <Grid.Column>
                        <Header color="teal">job postings by cities</Header>
                        <List>
                            <List.Item>city1(count)</List.Item>
                            <List.Item>city2(count)</List.Item>
                            <List.Item>city3(count)</List.Item>
                        </List>
                    </Grid.Column>
                    <Grid.Column>
                        <Header color="teal">job postings by job titles</Header>
                        <List>
                            {jobs.map((job) => (
                                <List.Item>{job.jobName}</List.Item>
                            ))}
                        </List>
                    </Grid.Column>
                </Grid.Row>
            </Grid>
        </div>
    )
}
