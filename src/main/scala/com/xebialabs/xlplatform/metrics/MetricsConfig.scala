/**
 * THIS CODE AND INFORMATION ARE PROVIDED "AS IS" WITHOUT WARRANTY OF ANY KIND, EITHER EXPRESSED OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY AND/OR FITNESS
 * FOR A PARTICULAR PURPOSE. THIS CODE AND INFORMATION ARE NOT SUPPORTED BY XEBIALABS.
 */
package com.xebialabs.xlplatform.metrics

import com.typesafe.config.ConfigFactory._

trait MetricsConfig {
  private lazy val productName = ServicesHolder.xlRepositoryConfig.repositoryName
  private lazy val config = parseResources("xl-metrics.conf").getObject(s"$productName.queries").toConfig

  def queries: Map[String, String] = {
    import collection.JavaConversions._
    config.entrySet().map(x => x.getKey -> x.getValue.unwrapped().toString).toMap
  }
}
