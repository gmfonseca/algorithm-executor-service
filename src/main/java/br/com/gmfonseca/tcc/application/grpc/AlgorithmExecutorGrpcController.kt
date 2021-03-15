package br.com.gmfonseca.tcc.application.grpc

import br.com.gmfonseca.tcc.application.rest.title
import br.com.gmfonseca.tcc.business.service.BubbleSortService
import br.com.gmfonseca.tcc.business.service.GenericAlgorithmService
import br.com.gmfonseca.tcc.business.service.HeapSortService
import br.com.gmfonseca.tcc.business.service.SelectionSortService
import br.com.gmfonseca.tcc.proto.AlgorithmExecutor
import br.com.gmfonseca.tcc.proto.AlgorithmExecutorServiceGrpc.AlgorithmExecutorServiceImplBase
import br.com.gmfonseca.tcc.shared.toAnComparableObjectList
import br.com.gmfonseca.tcc.shared.toAnObjectList
import io.grpc.stub.StreamObserver
import org.lognet.springboot.grpc.GRpcService

@GRpcService
class AlgorithmExecutorGrpcController : AlgorithmExecutorServiceImplBase() {

    private val bubbleSortService = BubbleSortService()
    private val selectionSortService = SelectionSortService()
    private val heapSortService = HeapSortService()

    override fun executeBubbleSortAlgorithm(
        request: AlgorithmExecutor.ExecuteSortAlgorithmRequest,
        responseObserver: StreamObserver<AlgorithmExecutor.ExecuteAlgorithmResult>
    ) {
        try {
            val result: AlgorithmExecutor.ExecuteAlgorithmResult = execute(bubbleSortService, request)

            responseObserver.onNext(result)
            responseObserver.onCompleted()
        } catch (t: Throwable) {
            responseObserver.onError(t)
        }
    }

    override fun executeSelectionSortAlgorithm(
        request: AlgorithmExecutor.ExecuteSortAlgorithmRequest,
        responseObserver: StreamObserver<AlgorithmExecutor.ExecuteAlgorithmResult>
    ) {
        try {
            val result: AlgorithmExecutor.ExecuteAlgorithmResult = execute(selectionSortService, request)

            responseObserver.onNext(result)
            responseObserver.onCompleted()
        } catch (t: Throwable) {
            responseObserver.onError(t)
        }
    }

    override fun executeHeapSortAlgorithm(
        request: AlgorithmExecutor.ExecuteSortAlgorithmRequest,
        responseObserver: StreamObserver<AlgorithmExecutor.ExecuteAlgorithmResult>
    ) {
        try {
            val result: AlgorithmExecutor.ExecuteAlgorithmResult = execute(heapSortService, request)

            responseObserver.onNext(result)
            responseObserver.onCompleted()
        } catch (t: Throwable) {
            responseObserver.onError(t)
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun execute(
        service: GenericAlgorithmService,
        request: AlgorithmExecutor.ExecuteSortAlgorithmRequest
    ): AlgorithmExecutor.ExecuteAlgorithmResult {
        val type = request.dataCase.name.substringBefore("LIST").title()
        println("Start running ${service.name} for typeof $type")

        val result = when (request.dataCase) {
            AlgorithmExecutor.ExecuteSortAlgorithmRequest.DataCase.INTEGERLIST -> {
                val resultList = service.execute(request.integerList.contentList)
                val integerList = AlgorithmExecutor.IntegerList.newBuilder().addAllContent(resultList).build()
                AlgorithmExecutor.ExecuteAlgorithmResult.newBuilder().setIntegerList(integerList).build()
            }

            AlgorithmExecutor.ExecuteSortAlgorithmRequest.DataCase.FLOATLIST -> {
                val resultList = service.execute(request.floatList.contentList)
                val integerList = AlgorithmExecutor.FloatList.newBuilder().addAllContent(resultList).build()
                AlgorithmExecutor.ExecuteAlgorithmResult.newBuilder().setFloatList(integerList).build()
            }

            AlgorithmExecutor.ExecuteSortAlgorithmRequest.DataCase.OBJECTLIST -> {
                val resultList = service.execute(request.objectList.contentList.toAnComparableObjectList())
                val integerList =
                    AlgorithmExecutor.ObjectList.newBuilder().addAllContent(resultList.toAnObjectList()).build()
                AlgorithmExecutor.ExecuteAlgorithmResult.newBuilder().setObjectList(integerList).build()
            }

            else -> throw IllegalArgumentException("Unknown data case")
        }
        println("Successfully run ${service.name} for typeof $type")
        println()

        return result
    }

}
