import React, { useState, useEffect } from 'react';
import { Formik, useFormik } from "formik";
import { Link, NavLink } from "react-router-dom";
import * as Yup from 'yup';
import { Grid, Segment, Form, Button, Label, Modal } from 'semantic-ui-react';
import SectorService from '../../services/SectorService';
import PositionLevelService from '../../services/PositionLevelService';
import EducationLevelService from '../../services/EducationLevelService';
import JobService from '../../services/JobService';
import CityService from '../../services/CityService';
import JobTypeService from '../../services/JobTypeService';
import MilitaryStatuService from '../../services/MilitaryStatuService';
import WorkTypeService from '../../services/WorkTypeService';
import ExperienceService from '../../services/ExperienceService';
import JobAdvertisementService from '../../services/JobAdvertisementService';
import * as moment from 'moment';

function JobAdvertisementPosting() {
    let jobAdvertisementService = new JobAdvertisementService();

    const [sectors, setSectors] = useState([]);
    const [positionLevels, setPositionLevels] = useState([]);
    const [educationLevels, setEducationLevels] = useState([]);
    const [jobs, setJobs] = useState([]);
    const [cities, setCities] = useState([]);
    const [jobTypes, setJobTypes] = useState([]);
    const [militaryStatus, setMilitaryStatus] = useState([]);
    const [workTypes, setWorkTypes] = useState([]);
    const [experiences, setExperiences] = useState([]);

    const [open, setOpen] = React.useState(false);

    useEffect(() => {
        let sectorService = new SectorService();
        let positionLevelService = new PositionLevelService();
        let educationLevelService = new EducationLevelService();
        let jobService = new JobService();
        let cityService = new CityService();
        let jobTypeService = new JobTypeService();
        let militaryStatuService = new MilitaryStatuService();
        let workTypeService = new WorkTypeService();
        let experienceService = new ExperienceService();

        sectorService.getAllSectors().then((result) => { setSectors(result.data.data); });

        positionLevelService.getAllPositionLevels().then((result) => { setPositionLevels(result.data.data); })

        educationLevelService.getAllEducationLevels().then((result) => { setEducationLevels(result.data.data); })

        jobService.getAllJobs().then((result) => { setJobs(result.data.data); });

        cityService.getAllCities().then((result) => { setCities(result.data.data); })

        jobTypeService.getAllJobTypes().then((result) => { setJobTypes(result.data.data); })

        militaryStatuService.getAllMilitaryStatu().then((result) => { setMilitaryStatus(result.data.data); })

        workTypeService.getAllWorkTypes().then((result) => { setWorkTypes(result.data.data); })

        experienceService.getAllExperiences().then((result) => { setExperiences(result.data.data); })
    }, [])

    const getAllSectors = sectors.map((sector, index) => ({
        key: index,
        text: sector.sectorName,
        value: sector.sectorId
    }))

    const getAllPositionLevels = positionLevels.map((positionLevel, index) => ({
        key: index,
        text: positionLevel.positionlevelName,
        value: positionLevel.positionLevelId
    }))

    const getAllEducationLevels = educationLevels.map((educationLevel, index) => ({
        key: index,
        text: educationLevel.educationLevelName,
        value: educationLevel.educationLevelId
    }))

    const getAllJobs = jobs.map((job, index) => ({
        key: index,
        text: job.jobName,
        value: job.jobId
    }))

    const getAllCities = cities.map((city, index) => ({
        key: index,
        text: city.cityName,
        value: city.cityId
    }))

    const getAllJobTypes = jobTypes.map((jobType, index) => ({
        key: index,
        text: jobType.typeName,
        value: jobType.typeId
    }))

    const getAllMilitaryStatu = militaryStatus.map((militaryStatu, index) => ({
        key: index,
        text: militaryStatu.militaryStatuName,
        value: militaryStatu.militaryStatuId
    }))

    const getAllWorkTypes = workTypes.map((workType, index) => ({
        key: index,
        text: workType.workTypeName,
        value: workType.workTypeId
    }))

    const getAllExperiences = experiences.map((experience, index) => ({
        key: index,
        text: experience.experienceName,
        value: experience.experienceId
    }))

    const formik = useFormik({
        initialValues: {
            advertisementName: "",
            jobDescription: "",
            numberOfVacancies: "",
            jobSalary: "",
            releaseDate: moment().format("YYYY-MM-DD"),
            applicationDate: "",
            sectorId: "",
            positionLevelId: "",
            educationLevelId: "",
            id: 1,
            jobId: "",
            cityId: "",
            typeId: "",
            militaryStatuId: "",
            workTypeId: "",
            experienceId: ""
        },
        validationSchema: Yup.object({
            advertisementName: Yup.string().required("advertisement name is cannot be blank."),
            jobDescription: Yup.string().required("job description is cannot be blank."),
            numberOfVacancies: Yup.number().required("number of  vacancies must be at least 1 person. "),
            jobSalary: Yup.number(),
            sectorId: Yup.number().required("sector info is cannot be blank."),
            positionLevelId: Yup.number().required("position level is cannot be blank."),
            educationLevelId: Yup.number().required("educatiion level is cannot be blank"),
            jobId: Yup.number().required("job name is cannot beblank."),
            cityId: Yup.number().required("city info is cannot be blank."),
            typeId: Yup.number().required("job type is cannoy be blank."),
            militaryStatuId: Yup.number(),
            workTypeId: Yup.number().required("work type is cannot be blank."),
            experienceId: Yup.number(),
            releaseDate: Yup.date(),
            applicationDate: Yup.date()

        }),
        onSubmit: (values) => {
            let jobAdvertisement = {
                advertisementName: values.advertisementName,
                numberOfVacancies: values.numberOfVacancies,
                jobSalary: values.jobSalary,
                jobDescription: values.jobDescription,
                releaseDate: values.releaseDate,
                applicationDate: values.applicationDate,
                sector: { sectorId: values.sectorId },
                city: { cityId: values.cityId },
                positionLevel: { positionLevelId: values.positionLevelId },
                educationLevel: { educationLevelId: values.educationLevelId },
                employer: { id: values.id },
                job: { jobId: values.jobId },
                militaryStatu: { militaryStatuId: values.militaryStatuId },
                workType: { workTypeId: values.workTypeId },
                experience: { experienceId: values.experienceId },
                jobType: { typeId: values.typeId }
            }
            console.log(jobAdvertisement);
            jobAdvertisementService.addAdvertisement(jobAdvertisement).then((result) => console.log(result.data.message));
        }
    }
    )

    return (
        <div>
            <Segment inverted color='teal'>
                <h3>Create Job Advertisement</h3>
            </Segment>
            <Segment>
                <Formik>
                    <Form onSubmit={formik.handleSubmit}>
                        <Grid>
                            <Grid.Row>
                                <Grid.Column width={8}>
                                    <Form.Input
                                        label='Advertisement Name'
                                        placeholder='please enter advertisement name'
                                        onChange={(event, data) => formik.setFieldValue("advertisementName", data.value)}
                                        value={formik.values.advertisementName}
                                    />
                                    <Form.TextArea
                                        label='Job Description'
                                        placeholder='please enter job description'
                                        onChange={(event, data) => formik.setFieldValue("jobDescription", data.value)}
                                        value={formik.values.jobDescription}
                                    />
                                    {formik.errors.jobDescription && formik.touched.jobDescription && (
                                        <Label basic color="orange" pointing>
                                            {formik.errors.jobDescription}
                                        </Label>
                                    )}
                                    <Grid>
                                        <Grid.Row>
                                            <Grid.Column width={8}>
                                                <Form.Input
                                                    label='Release Date'
                                                    placeholder='Example : yyyy-mm-dd'
                                                    onChange={(event, data) => formik.setFieldValue("releaseDate", data.value)}
                                                    value={formik.values.releaseDate}
                                                />
                                                {formik.errors.releaseDate && formik.touched.releaseDate && (
                                                    <Label basic color="orange" pointing>
                                                        {formik.errors.releaseDate}
                                                    </Label>
                                                )}
                                            </Grid.Column>
                                            <Grid.Column width={8}>
                                                <Form.Input
                                                    label='Application Date'
                                                    placeholder='Example : yyyy-mm-dd'
                                                    onChange={(event, data) => formik.setFieldValue("applicationDate", data.value)}
                                                    value={formik.values.applicationDate}
                                                />
                                                {formik.errors.applicationDate && formik.touched.applicationDate && (
                                                    <Label basic color="orange" pointing>
                                                        {formik.errors.applicationDate}
                                                    </Label>
                                                )}
                                            </Grid.Column>
                                        </Grid.Row>
                                        <Grid.Row>
                                            <Grid.Column width={8}>
                                                <Form.Input
                                                    label='Job Salary'
                                                    placeholder='Example 3850'
                                                    onChange={(event, data) => formik.setFieldValue("jobSalary", data.value)}
                                                    value={formik.values.jobSalary}
                                                />
                                                {formik.errors.jobSalary && formik.touched.jobSalary && (
                                                    <Label basic color="orange" pointing>
                                                        {formik.errors.jobSalary}
                                                    </Label>
                                                )}
                                            </Grid.Column>
                                            <Grid.Column width={8}>
                                                <Form.Input
                                                    label='Number Of Vacancies'
                                                    placeholder='Example 5'
                                                    onChange={(event, data) => formik.setFieldValue("numberOfVacancies", data.value)}
                                                    value={formik.values.numberOfVacancies}
                                                />
                                                {formik.errors.numberOfVacancies && formik.touched.numberOfVacancies && (
                                                    <Label basic color="orange" pointing>
                                                        {formik.errors.numberOfVacancies}
                                                    </Label>
                                                )}
                                            </Grid.Column>
                                        </Grid.Row>
                                        <Grid.Row>
                                            <Grid.Column width={8}>
                                                <Form.Select
                                                    label='Sector'
                                                    placeholder='Choose Sector'
                                                    options={getAllSectors}
                                                    onChange={(event, data) => formik.setFieldValue("sectorId", data.value)}
                                                    value={formik.values.sectorId}
                                                />
                                                {formik.errors.sectorId && formik.touched.sectorId && (
                                                    <Label basic color="orange" pointing>
                                                        {formik.errors.sectorId}
                                                    </Label>
                                                )}
                                            </Grid.Column>
                                            <Grid.Column width={8}>
                                                <Form.Select
                                                    label='Job'
                                                    placeholder='Choose Job'
                                                    options={getAllJobs}
                                                    onChange={(event, data) => formik.setFieldValue("jobId", data.value)}
                                                    value={formik.values.jobId}
                                                />
                                                {formik.errors.jobId && formik.touched.jobId && (
                                                    <Label basic color="orange" pointing>
                                                        {formik.errors.jobId}
                                                    </Label>
                                                )}
                                            </Grid.Column>
                                        </Grid.Row>
                                    </Grid>
                                </Grid.Column>
                                <Grid.Column width={8}>
                                    <Grid>
                                        <Grid.Row>
                                            <Grid.Column width={8}>
                                                <Form.Select
                                                    label='Position Level'
                                                    placeholder='Choose Position'
                                                    options={getAllPositionLevels}
                                                    onChange={(event, data) => formik.setFieldValue("positionLevelId", data.value)}
                                                    value={formik.values.positionLevelId}
                                                />
                                                {formik.errors.positionLevelId && formik.touched.positionLevelId && (
                                                    <Label basic color="orange" pointing>
                                                        {formik.errors.positionLevelId}
                                                    </Label>
                                                )}
                                            </Grid.Column>
                                            <Grid.Column width={8}>
                                                <Form.Select
                                                    label='Education Level'
                                                    placeholder='Choose Education Info'
                                                    options={getAllEducationLevels}
                                                    onChange={(event, data) => formik.setFieldValue("educationLevelId", data.value)}
                                                    value={formik.values.educationLevelId}
                                                />
                                                {formik.errors.educationLevelId && formik.touched.educationLevelId && (
                                                    <Label basic color="orange" pointing>
                                                        {formik.errors.educationLevelId}
                                                    </Label>
                                                )}
                                            </Grid.Column>
                                        </Grid.Row>
                                        <Grid.Row>
                                            <Grid.Column width={8}>
                                                <Form.Select
                                                    label='City'
                                                    placeholder='Choose City'
                                                    options={getAllCities}
                                                    onChange={(event, data) => formik.setFieldValue("cityId", data.value)}
                                                    value={formik.values.cityId}
                                                />
                                                {formik.errors.cityId && formik.touched.cityId && (
                                                    <Label basic color="orange" pointing>
                                                        {formik.errors.cityId}
                                                    </Label>
                                                )}
                                            </Grid.Column>
                                            <Grid.Column width={8}>
                                                <Form.Select
                                                    label='Job Type'
                                                    placeholder='Choose Job Type'
                                                    options={getAllJobTypes}
                                                    onChange={(event, data) => formik.setFieldValue("typeId", data.value)}
                                                    value={formik.values.typeId}
                                                />
                                                {formik.errors.typeId && formik.touched.typeId && (
                                                    <Label basic color="orange" pointing>
                                                        {formik.errors.typeId}
                                                    </Label>
                                                )}
                                            </Grid.Column>
                                        </Grid.Row>
                                        <Grid.Row>
                                            <Grid.Column width={8}>
                                                <Form.Select
                                                    label='Military Statu'
                                                    placeholder='Choose Military Statu'
                                                    options={getAllMilitaryStatu}
                                                    onChange={(event, data) => formik.setFieldValue("militaryStatuId", data.value)}
                                                    value={formik.values.militaryStatuId}
                                                />
                                                {formik.errors.militaryStatuId && formik.touched.militaryStatuId && (
                                                    <Label basic color="orange" pointing>
                                                        {formik.errors.militaryStatuId}
                                                    </Label>
                                                )}
                                            </Grid.Column>
                                            <Grid.Column width={8}>
                                                <Form.Select
                                                    label='Work Type'
                                                    placeholder='Choose Work Type'
                                                    options={getAllWorkTypes}
                                                    onChange={(event, data) => formik.setFieldValue("workTypeId", data.value)}
                                                    value={formik.values.workTypeId}
                                                />
                                                {formik.errors.workTypeId && formik.touched.workTypeId && (
                                                    <Label basic color="orange" pointing>
                                                        {formik.errors.workTypeId}
                                                    </Label>
                                                )}
                                            </Grid.Column>
                                        </Grid.Row>
                                        <Grid.Row>
                                            <Grid.Column width={8}>
                                                <Form.Select
                                                    label='Experience'
                                                    placeholder='Choose Experience'
                                                    options={getAllExperiences}
                                                    onChange={(event, data) => formik.setFieldValue("experienceId", data.value)}
                                                    value={formik.values.experienceId}
                                                />
                                                {formik.errors.experienceId && formik.touched.experienceId && (
                                                    <Label basic color="orange" pointing>
                                                        {formik.errors.experienceId}
                                                    </Label>
                                                )}
                                            </Grid.Column>
                                            <Grid.Column width={8}>
                                            </Grid.Column>
                                        </Grid.Row>
                                    </Grid>
                                </Grid.Column>
                            </Grid.Row>
                        </Grid>
                        <Modal
                            centered={false}
                            open={open}
                            onClose={() => setOpen(false)}
                            onOpen={() => setOpen(true)}
                            trigger={<Button inverted color='green' type="submit" style={{ marginTop: '2em' }}>Create Job Advertisement</Button>}
                        >
                            <Modal.Header>Thank you!</Modal.Header>
                            <Modal.Content>
                                <Modal.Description>
                                    your job advertisement sended. when system employee approve your job advertisements, it will be on advertisements table.
                                </Modal.Description>
                            </Modal.Content>
                            <Modal.Actions>
                                <Button onClick={() => setOpen(false)}>
                                    <Link to={`/advertisements`}>
                                        OK
                                    </Link>
                                </Button>
                            </Modal.Actions>
                        </Modal>

                    </Form>
                </Formik>
            </Segment>
        </div>
    )
}

export default JobAdvertisementPosting;
