package cn.star.test;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈mybatis测试类〉
 *
 * @author OneStar
 * @create 2019/11/11
 * @since 1.0.0
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring.xml"})
public class mybatistest {
    @Autowired
    private ProcessEngine processEngine;//流程引擎对象
    @Autowired
    private RepositoryService repositoryService;//工作流仓储服务
    @Autowired
    private RuntimeService runtimeService;//工作流运行服务
    @Autowired
    private TaskService taskService;//工作流任务服务
    @Autowired
    private HistoryService historyService;//工作流历史数据服务
    /**
     * 测试
     *
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        System.out.println(processEngine);
    }

    /**
     * bushuliuchengdiyi
     *
     * @throws Exception
     */
    @Test
    public void deploy() {
        Deployment deployment = repositoryService.createDeployment().name("hello")
                .addClasspathResource("bpnm/Process-1.bpmn").addClasspathResource("bpnm/Process-1.png").deploy();
        System.out.println(
                deployment.getId()+"、、、、、、、、、、、"+deployment.getName()
        );
    }

    /**查看流程定义
     * 	id:(key):(version):(随机值)
     * 	name:对应流程文件process节点的name属性
     *  key:对应流程文件process节点的id属性
     *  version:发布时自动生成的。如果是第一次发布的流程，version默认从1开始；
     *  如果当前流程引擎中已存在相同的流程，则找到当前key对应的最高版本号，在最高版本号上加1
     *  */

    @Test
    public void queryProcessDefinition() throws Exception{
        //获取仓库服务对象，使用版本的升级排列，查询列表
        List<ProcessDefinition> pdList=repositoryService
                .createProcessDefinitionQuery()
                //添加查询条件
                //.processDefinitionId(processDefinitionId)
                //.processDefinitionKey(processDefinitionKey)
                //.processDefinitionName(processDefinitionName)
                //排序(可以按照id/key/name/version/Cagetory排序)
                .orderByProcessDefinitionVersion().asc()
                //.count()
                //.listPage(firstResult, maxResults)
                //.singleResult()
                .list();//总的结果集数量
        //便利集合，查看内容
        for (ProcessDefinition pd:pdList) {
            System.out.println("id:"+pd.getId());

            System.out.println("name:"+pd.getName());
            System.out.println("key:"+pd.getKey());
            System.out.println("version:"+pd.getVersion());
            System.out.println("###########################################");
        }
    }
    /**
     * 启动流程
     */
    @Test
    public void flowStart() throws Exception{

        //在启动时设置流程变量
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance =runtimeService.startProcessInstanceByKey("HelloWorld");


        System.out.println("processInstanceId +"+processInstance.getId());//流程实例ID
        System.out.println("processInstanceDeploymentId +"+processInstance.getDeploymentId());//流程定义ID
        System.out.println("###########################################");
//        RepositoryService repositoryService = processEngine.getRepositoryService();
//        ProcessDefinition processDefinition = repositoryService.getProcessDefinition(processInstance.getDeploymentId());
//        System.out.println("processDefinitionId +"+processDefinition.getId());//流程实例ID
//        System.out.println("processDefinitionKey +"+processDefinition.getKey());//流程定义ID
    }


    /*
     *查看任务
     * 使用TaskService查看任务
     */
    @Test
    public void queryPersonalTask() throws Exception{



        //任务办理者
        String assignee1 = "张三";
        String assignee2 = "李四";
        String assignee3 = "王五";
        List<Task> tasks1 = processEngine.getTaskService()
                .createTaskQuery()
                .taskAssignee(assignee1)
                .list();
        System.out.println("###########################################");
        //遍历任务内容
        for (Task task:tasks1){
            System.out.println("taskId+"+task.getId()+",TaskName+"+task.getName());
            System.out.println("createTime+"+task.getCreateTime()+",assignee+"+task.getAssignee());
        }
        List<Task> tasks2 = processEngine.getTaskService()
                .createTaskQuery()
                .taskAssignee(assignee2)
                .list();
        System.out.println("###########################################");
        //遍历任务内容
        for (Task task:tasks2){
            System.out.println("taskId+"+task.getId()+",TaskName+"+task.getName());
            System.out.println("createTime+"+task.getCreateTime()+",assignee+"+task.getAssignee());
        }
        System.out.println("###########################################");




        List<Task> tasks3 = processEngine.getTaskService()
                .createTaskQuery()
                .taskAssignee(assignee3)
                .list();
        System.out.println("###########################################");
        //遍历任务内容
        for (Task task:tasks3){
            System.out.println("taskId+"+task.getId()+",TaskName+"+task.getName());
            System.out.println("createTime+"+task.getCreateTime()+",assignee+"+task.getAssignee());
        }

    }

    /*
     *办理任务
     *
     */
    @Test
    public void complete() throws Exception{

        String taskId = "10011";
        processEngine.getTaskService().complete(taskId);

    }

    /*
     *办理任务
     *act_ru_execution中的流程Id是一直不会变的
     */
    @Test
    public void queryProcessState() throws Exception{

        String processInstanceId = "7508";
        ProcessInstance processInstance = processEngine.getRuntimeService()
                .createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        if(processInstance!=null){
            System.out.println("当前流程在："+processInstance.getActivityId());
        }else {
            System.out.println("流程已经结束");
        }
    }


}